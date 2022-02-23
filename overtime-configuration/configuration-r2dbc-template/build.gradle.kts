dependencies {
    api(commonProject("service"))
    api(D.Spring.Boot.Data.R2dbc.notationNov)
    api(D.Spring.Boot.Autoconfigure.notationNov)

    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.notationNov)
    annotationProcessor(D.Lombok.notation)
    compileOnly(D.Lombok.notation)
}
