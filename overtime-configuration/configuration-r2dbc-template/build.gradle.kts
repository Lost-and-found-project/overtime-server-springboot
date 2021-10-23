dependencies {
    api(commonProject("service"))
    api(D.Spring.Boot.Data.R2dbc.NOTATION_NOV)
    api(D.Spring.Boot.Autoconfigure.NOTATION_NOV)

    annotationProcessor(D.Spring.Boot.ConfigurationProcessor.NOTATION_NOV)
    annotationProcessor(D.Lombok.NOTATION)
    compileOnly(D.Lombok.NOTATION)
}
