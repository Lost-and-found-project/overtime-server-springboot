plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

kotlin {
    sourceSets.all {
        languageSettings {
            useExperimentalAnnotation("kotlin.Experimental")
            useExperimentalAnnotation("kotlin.RequiresOptIn")
        }
    }
}


dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-gradle-plugin", "1.5.31")
    implementation("org.jetbrains.kotlin", "kotlin-compiler-embeddable", "1.5.31")
    api(gradleApi())
}