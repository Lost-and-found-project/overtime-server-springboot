plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

kotlin {
    sourceSets.all {
        languageSettings {
            optIn("kotlin.Experimental")
            optIn("kotlin.RequiresOptIn")
        }
    }
}


dependencies {
    //implementation(kotlin("gradle-plugin", "1.5.31"))
    //implementation(kotlin("compiler-embeddable", "1.5.31"))
    api(gradleApi())
}