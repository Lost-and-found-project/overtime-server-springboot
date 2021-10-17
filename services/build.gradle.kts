val p = project

subprojects {
    println(">> $p sub project: '$this' named $name")

    dependencies {
        implementation(project(":overtime-domain-common"))
        implementation(D.SpringBoot.DataR2dbc.NOTATION)
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
            // And?
        }

        if (name == "controller") {
            implementation(findSameLevel("domain")!!)
            implementation(findSameLevel("repository")!!)
            implementation(findSameLevel("service")!!)
            implementation(findSameLevel("service-impl")!!)
            implementation(D.SpringBoot.Webflux.NOTATION_NOV)
            implementation(D.SpringBoot.DataR2dbc.NOTATION)
            implementation(D.SpringBoot.Aop.NOTATION_NOV)
            implementation(D.R2dbc.Pool.NOTATION)
            implementation(D.R2dbc.Mysql.NOTATION)
            annotationProcessor(D.SpringBoot.ConfigurationProcessor.NOTATION_NOV)

        }

    }
}
println()


