plugins {
    `java-library`
}

dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.notation)
        mavenBom(D.Alibaba.Cloud.Dependencies.notation)
    }
}

dependencies {
    api(project(":overtime-admins:overtime-admin-domain"))
    //region annotationProcessors
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.notationNov)
    annotationProcessor(D.Lombok.notation)
    compileOnly(D.Lombok.notation)
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
    api(commonProject("jwt"))
    //endregion

    //region configs
    api(configProject("r2dbc-template"))

    //endregion

    //region spring
    api(D.Spring.Boot.Autoconfigure.notationNov)
    api(D.Spring.Boot.Webflux.notationNov)
    api(D.Spring.Cloud.Bootstrap.notationNov)
    // 服务发现，但是不注册服务?
    api(D.Alibaba.Cloud.Nacos.Discovery.notationNov)
    api(D.Alibaba.Cloud.Nacos.Config.notationNov)
    api(D.Spring.Boot.Actuator.notationNov)
    // feign reactor
    api(D.FeignReactor.WebClient.notation)
    api(D.FeignReactor.Cloud.notation)
    api(D.FeignReactor.SpringConfiguration.notation)
    //endregion

    //region r2dbc
    // R2dbc
    api(D.Spring.Boot.Data.R2dbc.notationNov)
    api(D.R2dbc.Mysql.notation)
    api(D.R2dbc.Pool.notation)
    //endregion
}


