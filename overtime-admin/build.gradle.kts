dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
        mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
    }
}

dependencies {
    //region annotationProcessors
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)
    //endregion

    //region commons
    implementation(commonProject("core"))
    implementation(commonProject("domain"))
    implementation(commonProject("service"))
    implementation(commonProject("application"))
    implementation(commonProject("jwt"))
    //endregion

    //region configs
    implementation(configProject("handler"))
    //endregion

    //region spring
    implementation(D.Spring.Boot.Webflux.NOTATION_NOV)
    implementation(D.Spring.Cloud.Bootstrap.NOTATION_NOV)
    // 服务发现，但是不注册服务
    implementation(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
    implementation(D.Alibaba.Cloud.Nacos.Config.NOTATION_NOV)
    implementation(D.Spring.Boot.Actuator.NOTATION_NOV)
    //endregion

    //region r2dbc
    // R2dbc
    implementation(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
    implementation(D.R2dbc.Mysql.NOTATION)
    implementation(D.R2dbc.Pool.NOTATION)
    //endregion



}
