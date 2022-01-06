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


}



tasks.bootJar {
    enabled = true
}