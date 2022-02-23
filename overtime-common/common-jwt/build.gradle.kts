plugins {
    `java-library`
}


dependencies {
    api(D.Jwt.Jjwt.Api.notation)
    runtimeOnly(D.Jwt.Jjwt.Impl.notation)
    runtimeOnly(D.Jwt.Jjwt.Jackson.notation)
}