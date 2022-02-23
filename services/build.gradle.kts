// plugins {
//     `java-library`
// }

val p = project


subprojects {
    println(">> $p sub project: '$this' named $name")

    dependencies {
        annotationProcessor(D.Spring.Boot.ConfigurationProcessor.notationNov)
        annotationProcessor(D.Lombok.notation)
        compileOnly(D.Lombok.notation)
        testAnnotationProcessor(D.Lombok.notation)
        testCompileOnly(D.Lombok.notation)

        if (name.endsWith("-domain")) {
            apply(plugin = "java-library")
            api(commonProject("domain"))
            api(D.Spring.Boot.Data.R2dbc.notationNov)
        }

        if (name.endsWith("-repository")) {
            apply(plugin = "java-library")
            api(findServicesSameLevel("domain")!!)
            api(commonProject("repository"))
            api(D.Spring.Boot.Webflux.notationNov)
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
                    mavenBom(D.Spring.Cloud.Dependencies.notation)
                }
            }
            // feign compile only.
            // compileOnly(D.Spring.Cloud.Openfeign.NOTATION_NOV)
            compileOnly(D.FeignReactor.WebClient.notation)
            compileOnly(D.FeignReactor.Cloud.notation)
            compileOnly(D.FeignReactor.SpringConfiguration.notation)
        }

        if (name.endsWith("-controller")) {
            apply(plugin = "java-library")
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.notation)
                    mavenBom(D.Alibaba.Cloud.Dependencies.notation)
                }
            }
            api(findServicesSameLevel("service-impl")!!)
            api(findServicesSameLevel("api")!!)
            api(configProject("handler"))

            implementation(D.Alibaba.Cloud.Nacos.Discovery.notationNov)

            api(D.Spring.Boot.Data.R2dbc.notationNov)
            api(D.Spring.Boot.Aop.notationNov)
            api(D.R2dbc.Pool.notation)
            api(D.R2dbc.Mysql.notation)
        }

        if (name.endsWith("-application")) {
            apply(plugin = "java-library")
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.notation)
                    mavenBom(D.Alibaba.Cloud.Dependencies.notation)
                }
            }
            implementation(commonProject("application"))
            implementation(findServicesSameLevel("controller")!!)
            implementation(D.Alibaba.Cloud.Nacos.Discovery.notationNov)
            implementation(D.Alibaba.Cloud.Nacos.Config.notationNov)
            implementation(D.Spring.Cloud.Bootstrap.notationNov)
            implementation(D.Spring.Boot.Actuator.notationNov)

            tasks.bootJar {
                enabled = true
            }
        }
    }
}
println()


