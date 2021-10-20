// buildscript {
//     dependencies {
//         classpath("io.spring.gradle:dependency-management-plugin:1.0.10.RELEASE")
//     }
// }

dependencyManagement {
    imports {
        mavenBom(D.Spring.Cloud.Dependencies.NOTATION)
        mavenBom(D.Alibaba.Cloud.Dependencies.NOTATION)
    }
}


dependencies {
    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)

    // implementation(D.Spring.Boot.Web.NOTATION_NOV)
    implementation(D.Spring.Boot.Webflux.NOTATION_NOV)
    // cloud
    implementation(D.Spring.Cloud.Gateway.NOTATION_NOV)
    implementation(D.Spring.Cloud.Bootstrap.NOTATION_NOV)

    @Suppress("DEPRECATION")
    implementation(D.Spring.Cloud.Openfeign.NOTATION_NOV)
    implementation(D.Spring.Cloud.Loadbalancer.NOTATION_NOV)
    implementation(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
    implementation(D.Alibaba.Cloud.Nacos.Config.NOTATION_NOV)
    implementation(D.Spring.Boot.Actuator.NOTATION_NOV)

    // alibaba cloud
}
