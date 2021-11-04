dependencies {
    api(commonProject("core"))
    api(D.Spring.Boot.Aop.NOTATION_NOV)
    api(D.Spring.Boot.Webflux.NOTATION_NOV)

    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)
}