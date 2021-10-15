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
            println("${this@subprojects} implementation domain-common")
        }
    }
}
println()

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

