@file:Suppress("PropertyName")

plugins {
    id("org.springframework.boot") version "2.5.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    java
}

val GROUP_NAME = "org.overtime"
val VERSION = "0.0.1-SNAPSHOT"

group = GROUP_NAME //"org.overtime"
version = VERSION
java {
    sourceCompatibility = JavaVersion.VERSION_17
}

val p = project

subprojects {
    repositories {
        mavenCentral()
    }
    group = p.group
    version = p.version
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    java {
        // Set Java 17
        sourceCompatibility = JavaVersion.VERSION_17
    }
    this.tasks.named<JavaCompile>("compileJava") {
       options.compilerArgs.addAll(listOf(
           "-parameters",
       ))
    }

    dependencies {
        compileOnly(D.JetbrainsAnnotation.NOTATION)
        testImplementation(D.Jupiter.Api.NOTATION)
        testRuntimeOnly(D.Jupiter.Engine.NOTATION)
    }

}




// configurations {
//     compileOnly {
//         extendsFrom annotationProcessor
//     }
// }

repositories {
    mavenCentral()
}

dependencies {
    // implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    // implementation("∂org.springframework.boot:spring-boot-starter-data-redis-reactive")
    // implementation("org.springframework.boot:spring-boot-starter-webflux")
    // compileOnly("org.projectlombok:lombok")
    // annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    // annotationProcessor("org.projectlombok:lombok")
    // testImplementation("org.springframework.boot:spring-boot-starter-test")
    // testImplementation("io.projectreactor:reactor-test")
}

tasks.forEach {
    it.enabled = false
}



