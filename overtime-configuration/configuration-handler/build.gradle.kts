dependencies {
    api(commonProject("core"))
    api(D.Spring.Boot.Aop.notationNov)
    api(D.Spring.Boot.Webflux.notationNov)

    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.notationNov)
    annotationProcessor(D.Lombok.notation)
    compileOnly(D.Lombok.notation)
}