plugins {
    java
    `java-library`
}

dependencies {
    // api(serviceProject("compensate", "api"))
    val dep = api(project(":services:compensate:api"))
    println(">>>>>> api pro: $dep")



}
