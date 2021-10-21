plugins {
    `java-library`
}


dependencies {
    api(D.Jwt.Jjwt.Api.NOTATION)
    runtimeOnly(D.Jwt.Jjwt.Impl.NOTATION)
    runtimeOnly(D.Jwt.Jjwt.Jackson.NOTATION)
}