plugins {
    `java-library`
}
val p = project

dependencies {
}

subprojects {
    println(">> $p sub project: '$this' named $name")

    dependencies {
        annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
        annotationProcessor(D.Lombok.NOTATION)
        compileOnly(D.Lombok.NOTATION)
        testAnnotationProcessor(D.Lombok.NOTATION)
        testCompileOnly(D.Lombok.NOTATION)

        if (name == "domain") {
            api(project(":overtime-common:common-domain"))
            api(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
        }

        if (name == "repository") {
            api(findSameLevel("domain")!!)
            api(D.Spring.Boot.Webflux.NOTATION_NOV)
        }
        if (name == "service") {
            api(findSameLevel("repository")!!)
        }

        if (name == "service-impl") {
            // api(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
            api(findSameLevel("service")!!)
            api(project(":overtime-common:common-service"))
        }

        if (name == "api") {
            api(findSameLevel("service")!!)
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
                }
            }
            // feign compile only.
            compileOnly(D.Spring.Cloud.Openfeign.NOTATION_NOV)
        }

        if (name == "controller") {
            /*
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
                <version>${latest.version}</version>
            </dependency>
             */
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
                    mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
                }
            }
            implementation(configProject("dataSource"))
            api(findSameLevel("service-impl")!!)
            api(findSameLevel("api")!!)
            api(configProject("handler"))
            api(commonProject("controller"))
            api(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
            api(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
            api(D.Spring.Boot.Aop.NOTATION_NOV)
            api(D.R2dbc.Pool.NOTATION)
            api(D.R2dbc.Mysql.NOTATION)
        }


    }
}
println()


