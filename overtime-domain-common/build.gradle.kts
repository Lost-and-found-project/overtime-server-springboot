plugins {
    java

}

group = "org.overtime"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(D.SBStarter.DataR2dbc.NOTATION)
}

tasks.getByName<Test>("test") {
    // useJUnit()
    useJUnitPlatform()
}