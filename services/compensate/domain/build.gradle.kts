plugins {
    java
}

group = "org.overtime"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // implementation(project(":"))
    // testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    // testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}