plugins {
    `java-library`
}

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

    //region services
    api(serviceApiProject("dictionary"))
    api(serviceApiProject("user"))
    //endregion

    //region commons
    api(commonProject("core"))
    api(commonProject("domain"))
    api(commonProject("service"))
    api(commonProject("repository"))
    api(commonProject("application"))
    api(commonProject("jwt"))
    //endregion

    //region configs
    api(configProject("handler"))
    api(configProject("r2dbc-template"))

    //endregion

    //region spring
    api(D.Spring.Boot.Autoconfigure.NOTATION_NOV)
    api(D.Spring.Boot.Webflux.NOTATION_NOV)
    api(D.Spring.Cloud.Bootstrap.NOTATION_NOV)
    // 服务发现，但是不注册服务?
    api(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
    api(D.Alibaba.Cloud.Nacos.Config.NOTATION_NOV)
    api(D.Spring.Boot.Actuator.NOTATION_NOV)
    // feign reactor
    api(D.FeignReactor.WebClient.NOTATION)
    api(D.FeignReactor.Cloud.NOTATION)
    api(D.FeignReactor.SpringConfiguration.NOTATION)
    //endregion

    //region r2dbc
    // R2dbc
    api(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
    api(D.R2dbc.Mysql.NOTATION)
    api(D.R2dbc.Pool.NOTATION)
    //endregion
}


