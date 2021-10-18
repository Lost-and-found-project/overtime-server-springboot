val p = project

subprojects {
    println(">> $p sub project: '$this' named $name")


    dependencies {
        implementation(project(":overtime-domain-common"))
        implementation(D.Spring.Boot.Data.R2dbc.NOTATION)
        annotationProcessor(D.Lombok.NOTATION)
        compileOnly(D.Lombok.NOTATION)
        testAnnotationProcessor(D.Lombok.NOTATION)
        testCompileOnly(D.Lombok.NOTATION)
        // if (name == "domain") {
            // println("${this@subprojects} implementation domain-common、lombok、r2dbc")
        // }

        if (name == "repository") {
            implementation(findSameLevel("domain")!!)
        }
        if (name == "service") {
            implementation(findSameLevel("domain")!!)
            implementation(findSameLevel("repository")!!)
        }
        if (name == "service-impl") {
            implementation(findSameLevel("domain")!!)
            implementation(findSameLevel("repository")!!)
            implementation(findSameLevel("service")!!)
            implementation(project(":overtime-service-common"))
        }
        if (name == "resources") {
            implementation(findSameLevel("domain")!!)
            implementation(findSameLevel("repository")!!)
            implementation(findSameLevel("service")!!)
            implementation(D.Spring.Web.NOTATION_NOV)
            // And?
        }

        if (name == "controller") {
            implementation(findSameLevel("domain")!!)
            implementation(findSameLevel("repository")!!)
            implementation(findSameLevel("service")!!)
            implementation(findSameLevel("service-impl")!!)
            implementation(D.Spring.Boot.Webflux.NOTATION_NOV)
            implementation(D.Spring.Boot.Data.R2dbc.NOTATION)
            implementation(D.Spring.Boot.Aop.NOTATION_NOV)
            implementation(D.R2dbc.Pool.NOTATION)
            implementation(D.R2dbc.Mysql.NOTATION)
            annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
        }

        if (name == "client") {
            dependencyManagement {
                imports {
                    mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
                }
            }



        }

    }
}
println()


