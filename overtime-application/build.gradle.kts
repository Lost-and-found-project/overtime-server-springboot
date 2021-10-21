plugins {
    java
    id("org.springframework.boot") // version "2.5.5" // apply false
    id("io.spring.dependency-management") // version "1.0.11.RELEASE"

}

val serviceProject = project(":services")
val serviceControllers = serviceProject.childProjects.values.flatMap {
    it.childProjects.values
}.filter { it.name.endsWith("-controller") }.map {
    it.path
}

dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
        mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
    }
}

dependencies {
    val discovery = D.Alibaba.Cloud.Nacos.Discovery
    val config = D.Alibaba.Cloud.Nacos.Config
    val bootstrap = D.Spring.Cloud.Bootstrap

    serviceControllers.forEach {
        implementation(project(it)) {
            exclude(discovery.groupId, discovery.name)
            exclude(config.groupId, config.name)
            exclude(bootstrap.groupId, bootstrap.name)
        }
        println(">> Controller : $it")
    }
    implementation(D.Spring.Boot.Data.R2dbc.NOTATION)
    implementation(D.Spring.Boot.Aop.NOTATION_NOV)
    implementation(D.R2dbc.Pool.NOTATION)
    implementation(D.R2dbc.Mysql.NOTATION) // 0.8.2.RELEASE
    implementation(D.Spring.Boot.Webflux.NOTATION_NOV)
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}