dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
        mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
    }
}

dependencies {
    implementation(project(":overtime-admins:overtime-admin-api"))
    implementation(configProject("handler"))

    //region annotationProcessors
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)
    //endregion

    implementation(commonProject("application"))
    // http://springfox.github.io/springfox/docs/current/#quick-start-guides

    // implementation("org.springframework.boot:spring-boot-starter-actuator")
    // implementation("org.springframework.boot:spring-boot-starter-integration")
    // implementation("org.springframework.integration:spring-integration-webflux")

    implementation("io.springfox:springfox-boot-starter:3.0.0")
    // implementation("io.springfox:springfox-swagger2:2.9.2")
    implementation("io.springfox:springfox-swagger-ui:2.9.2")
    // implementation("io.springfox:springfox-swagger2:3.0.0")
    // implementation("io.springfox:springfox-spring-webflux:3.0.0")
    // implementation("io.springfox:springfox-spring-integration-webflux:3.0.0")

}



tasks.bootJar {
    enabled = true
}