// plugins {
//     `java-library`
// }

val p = project


subprojects {
    println(">> $p sub project: '$this' named $name")

    dependencies {
        annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
        annotationProcessor(D.Lombok.NOTATION)
        compileOnly(D.Lombok.NOTATION)
        testAnnotationProcessor(D.Lombok.NOTATION)
        testCompileOnly(D.Lombok.NOTATION)

        if (name.endsWith("-domain")) {
            apply(plugin = "java-library")
            api(commonProject("domain"))
            api(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
        }

        if (name.endsWith("-repository")) {
            apply(plugin = "java-library")
            api(findServicesSameLevel("domain")!!)
            api(commonProject("repository"))
            api(D.Spring.Boot.Webflux.NOTATION_NOV)
        }
        if (name.endsWith("-service")) {
            apply(plugin = "java-library")
            api(findServicesSameLevel("repository")!!)
        }

        if (name.endsWith("-service-impl")) {
            apply(plugin = "java-library")
            api(commonProject("service"))
            api(configProject("r2dbc-template"))
            api(findServicesSameLevel("service")!!)
        }

        if (name.endsWith("-api")) {
            apply(plugin = "java-library")
            implementation(findServicesSameLevel("service")!!)
            api(findServicesSameLevel("domain")!!)
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
                }
            }
            // feign compile only.
            // compileOnly(D.Spring.Cloud.Openfeign.NOTATION_NOV)
            compileOnly(D.FeignReactor.WebClient.NOTATION)
            compileOnly(D.FeignReactor.Cloud.NOTATION)
            compileOnly(D.FeignReactor.SpringConfiguration.NOTATION)
        }

        if (name.endsWith("-controller")) {
            apply(plugin = "java-library")
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
                    mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
                }
            }
            api(findServicesSameLevel("service-impl")!!)
            api(findServicesSameLevel("api")!!)
            api(configProject("handler"))

            implementation(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)

            api(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
            api(D.Spring.Boot.Aop.NOTATION_NOV)
            api(D.R2dbc.Pool.NOTATION)
            api(D.R2dbc.Mysql.NOTATION)
        }

        if (name.endsWith("-application")) {
            apply(plugin = "java-library")
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
                    mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
                }
            }
            implementation(commonProject("application"))
            implementation(findServicesSameLevel("controller")!!)
            implementation(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
            implementation(D.Alibaba.Cloud.Nacos.Config.NOTATION_NOV)
            implementation(D.Spring.Cloud.Bootstrap.NOTATION_NOV)
            implementation(D.Spring.Boot.Actuator.NOTATION_NOV)

            tasks.bootJar {
                enabled = true
            }
        }
    }
}
println()


