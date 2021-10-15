plugins {
    java
}

group = "org.overtime"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val p = project

subprojects {
    println("$p sub project: '$this' named $name")
    if (name == "domain") {
        dependencies {
            implementation(project(":overtime-domain-common"))
            implementation(D.SBStarter.DataR2dbc.NOTATION)
            annotationProcessor(D.Lombok.NOTATION)
            compileOnly(D.Lombok.NOTATION)
            testAnnotationProcessor(D.Lombok.NOTATION)
            testCompileOnly(D.Lombok.NOTATION)
            println("${this@subprojects} implementation domain-common、lombok、r2dbc")
        }
    }
    tasks.getByName<Test>("test") {
        // useJUnit()
        useJUnitPlatform()
    }
}
println()

dependencies {
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

