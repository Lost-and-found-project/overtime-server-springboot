plugins {
    java
}

group = "org.overtime"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)
    // compileOnly("io.springfox:springfox-swagger-ui:3.0.0")
    compileOnly("io.springfox:springfox-boot-starter:3.0.0")

    api(commonProject("core"))
    api(commonProject("domain"))
    api(commonProject("repository"))
    api(commonProject("authentication"))
    api(configProject("r2dbc-template"))

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}