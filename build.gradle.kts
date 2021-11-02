@file:Suppress("PropertyName")

plugins {
    id("org.springframework.boot") version "2.5.5" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    java
    `java-library`
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
        gradlePluginPortal()
    }
    group = p.group
    version = p.version
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    java {
        // Set Java 17
        sourceCompatibility = JavaVersion.VERSION_17
    }
    tasks.named<JavaCompile>("compileJava") {
        options.compilerArgs.addAll(listOf(
            "-parameters",
        ))
    }
    tasks.named("bootJar") {
        enabled = false
    }

    tasks.test {
        useJUnitPlatform()
    }

    dependencies {
        compileOnly(D.JetbrainsAnnotation.NOTATION)
        testImplementation(D.Jupiter.Api.NOTATION)
        testRuntimeOnly(D.Jupiter.Engine.NOTATION)

        testImplementation(D.Spring.Boot.Test.NOTATION_NOV)
        testImplementation(D.Reactor.Test.NOTATION_NOV)
    }


}

repositories {
    mavenCentral()
}


tasks.forEach {
    it.enabled = false
}



