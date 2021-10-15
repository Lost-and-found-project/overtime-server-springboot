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
    println("$p sub project: $this")
}
println()

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}