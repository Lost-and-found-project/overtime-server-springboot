plugins {
    `java-library`
}


subprojects {
    if (!this.name.endsWith("core")) {
        dependencies {
            api(commonProject("core"))
        }

    }
}
