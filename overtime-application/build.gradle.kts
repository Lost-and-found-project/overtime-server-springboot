plugins {
    java
    // id("io.spring.dependency-management")
    id("org.springframework.boot") // version "2.5.5" // apply false
    id("io.spring.dependency-management") // version "1.0.11.RELEASE"

}


dependencies {
    // Utils
    implementation(project(":overtime-utils"))
    implementation(project(":overtime-common"))
    implementation(project(":overtime-domain-common"))

    // implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.5")
    implementation(D.Spring.Boot.Data.R2dbc.NOTATION)
    implementation(D.Spring.Boot.Aop.NOTATION_NOV)
    implementation(D.R2dbc.Pool.NOTATION)
    implementation(D.R2dbc.Mysql.NOTATION) // 0.8.2.RELEASE
    // implementation("io.r2dbc:r2dbc-pool:0.8.7.RELEASE")
    // implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE") // 0.8.2.RELEASE

    // implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive:2.5.5")
    implementation(D.Spring.Boot.Webflux.NOTATION_NOV)
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)

    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)



}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}