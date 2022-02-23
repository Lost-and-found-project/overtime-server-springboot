dependencies {
    // implementation(D.Spring.Cloud.Loadbalancer.NOTATION_NOV)
    // implementation(D.Spring.Cloud.Openfeign.NOTATION_NOV)
    implementation(serviceApiProject("compensate"))
    implementation(D.FeignReactor.WebClient.notation)
    implementation(D.FeignReactor.Cloud.notation)
    implementation(D.FeignReactor.SpringConfiguration.notation)
}