dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.notation)
        mavenBom(D.Alibaba.Cloud.Dependencies.notation)
    }
}


dependencies {
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.notationNov)
    annotationProcessor(D.Lombok.notation)
    compileOnly(D.Lombok.notation)

    // implementation(D.Spring.Boot.Web.NOTATION_NOV)
    implementation(D.Spring.Boot.Webflux.notationNov)
    // cloud
    implementation(D.Spring.Cloud.Gateway.notationNov)
    implementation(D.Spring.Cloud.Bootstrap.notationNov)

    @Suppress("DEPRECATION")
    implementation(D.Spring.Cloud.Openfeign.notationNov)
    implementation(D.Spring.Cloud.Loadbalancer.notationNov)
    implementation(D.Alibaba.Cloud.Nacos.Discovery.notationNov)
    implementation(D.Alibaba.Cloud.Nacos.Config.notationNov)
    implementation(D.Spring.Boot.Actuator.notationNov)

    // alibaba cloud
}
