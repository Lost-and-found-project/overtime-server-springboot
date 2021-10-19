dependencies {
    // implementation(D.Spring.Cloud.Loadbalancer.NOTATION_NOV)
    // implementation(D.Spring.Cloud.Openfeign.NOTATION_NOV)
    implementation(serviceProject("compensate", "api"))
    implementation(D.FeignReactor.WebClient.NOTATION)
    implementation(D.FeignReactor.Cloud.NOTATION)
    implementation(D.FeignReactor.SpringConfiguration.NOTATION)
}