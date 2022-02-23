dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.notation)
        mavenBom(D.Alibaba.Cloud.Dependencies.notation)
    }
}

dependencies {
    annotationProcessor(D.Lombok.notation)
    compileOnly(D.Lombok.notation)
    implementation(D.Spring.Boot.Data.R2dbc.notationNov)
}