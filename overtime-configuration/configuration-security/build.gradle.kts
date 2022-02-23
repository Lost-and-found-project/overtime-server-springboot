dependencies {
    api(D.Spring.Boot.Security.notationNov)
    api(D.Spring.Boot.Autoconfigure.notationNov)

    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.notationNov)
    annotationProcessor(D.Lombok.notation)
    compileOnly(D.Lombok.notation)
}
