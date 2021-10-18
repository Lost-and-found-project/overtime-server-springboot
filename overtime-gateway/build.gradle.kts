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
    implementation(D.Spring.Boot.Webflux.NOTATION_NOV)

    // cloud
    implementation(D.Spring.Cloud.Gateway.NOTATION_NOV)
    implementation(D.Spring.Cloud.Openfeign.NOTATION_NOV)
    implementation(D.Spring.Cloud.Loadbalancer.NOTATION_NOV)
    implementation(D.Alibaba.Cloud.Nacos.Discovery.NOTATION_NOV)
    implementation(D.Alibaba.Cloud.Nacos.Config.NOTATION_NOV)

    // alibaba cloud
}
