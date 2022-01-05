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

    api(commonProject("core"))
    api(commonProject("domain"))
    api(commonProject("repository"))
    api(configProject("r2dbc-template"))

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}