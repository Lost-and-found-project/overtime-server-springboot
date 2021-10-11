plugins {
    id("org.springframework.boot") version "2.5.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    java
}

group = "org.overtime"
version = "0.0.1-SNAPSHOT"
java {
    sourceCompatibility = JavaVersion.VERSION_17
}

subprojects {
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
        compileOnly(Dependencies.JetbrainsAnnotation.NOTATION)


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



