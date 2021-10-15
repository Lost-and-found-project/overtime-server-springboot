plugins {
    java
    // id("io.spring.dependency-management")
    id("org.springframework.boot") // version "2.5.5" // apply false
    id("io.spring.dependency-management") // version "1.0.11.RELEASE"

}

group = "org.overtime"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Utils
    implementation(project(":overtime-utils"))
    implementation(project(":overtime-domain-common"))

    // implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.5")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc:2.5.5")
    implementation("io.r2dbc:r2dbc-pool:0.8.7.RELEASE")
    implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE") // 0.8.2.RELEASE

    // implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive:2.5.5")
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.5.5")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.5.5")
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)



}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}