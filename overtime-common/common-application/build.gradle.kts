dependencies {
    dependencyManagement {
        imports {
            mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
            mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
        }
    }
    implementation(configProject("handler"))
    implementation(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
    implementation(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
    implementation(D.Spring.Boot.Aop.NOTATION_NOV)
    implementation(D.R2dbc.Pool.NOTATION)
    implementation(D.R2dbc.Mysql.NOTATION)

    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)
    @Suppress("DEPRECATION")
    compileOnly(D.Spring.Cloud.Openfeign.NOTATION_NOV)
    compileOnly(D.FeignReactor.SpringConfiguration.NOTATION)

}