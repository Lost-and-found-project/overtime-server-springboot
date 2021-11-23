dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
        mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
    }
}

dependencies {
    implementation(project(":overtime-admins:overtime-admin-api"))

    //region annotationProcessors
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)
    //endregion

    //
    // //region services
    // implementation(serviceApiProject("dictionary"))
    // implementation(serviceApiProject("user"))
    // //endregion
    //
    // //region commons
    // implementation(commonProject("core"))
    // implementation(commonProject("domain"))
    // implementation(commonProject("service"))
    // implementation(commonProject("repository"))
    // implementation(commonProject("application"))
    // implementation(commonProject("jwt"))
    // //endregion
    //
    // //region configs
    // implementation(configProject("handler"))
    // implementation(configProject("r2dbc-template"))
    //
    // //endregion
    //
    // //region spring
    // implementation(D.Spring.Boot.Autoconfigure.NOTATION_NOV)
    // implementation(D.Spring.Boot.Webflux.NOTATION_NOV)
    // implementation(D.Spring.Cloud.Bootstrap.NOTATION_NOV)
    // // 服务发现，但是不注册服务
    // implementation(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
    // implementation(D.Alibaba.Cloud.Nacos.Config.NOTATION_NOV)
    // implementation(D.Spring.Boot.Actuator.NOTATION_NOV)
    // // feign reactor
    // implementation(D.FeignReactor.WebClient.NOTATION)
    // implementation(D.FeignReactor.Cloud.NOTATION)
    // implementation(D.FeignReactor.SpringConfiguration.NOTATION)
    // //endregion
    //
    // //region r2dbc
    // // R2dbc
    // implementation(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
    // implementation(D.R2dbc.Mysql.NOTATION)
    // implementation(D.R2dbc.Pool.NOTATION)
    //endregion
}



tasks.bootJar {
    enabled = true
}