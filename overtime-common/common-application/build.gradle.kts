dependencies {
    dependencyManagement {
        imports {
            mavenBom(D.Spring.Cloud.Dependencies.notation)
            mavenBom(D.Alibaba.Cloud.Dependencies.notation)
        }
    }
    implementation(configProject("handler"))
    implementation(D.Alibaba.Cloud.Nacos.Discovery.notationNov)
    implementation(D.Spring.Boot.Data.R2dbc.notationNov)
    implementation(D.Spring.Boot.Aop.notationNov)
    implementation(D.R2dbc.Pool.notation)
    implementation(D.R2dbc.Mysql.notation)

    annotationProcessor(D.Lombok.notation)
    compileOnly(D.Lombok.notation)
    @Suppress("DEPRECATION")
    compileOnly(D.Spring.Cloud.Openfeign.notationNov)
    compileOnly(D.FeignReactor.SpringConfiguration.notation)

}