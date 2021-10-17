/**
 * 依赖统一版本控制
 *
 *
 */
@Suppress("MemberVisibilityCanBePrivate")
object D {
    object JetbrainsAnnotation {
        const val VERSION = "22.0.0"
        const val NOTATION = "org.jetbrains:annotations:$VERSION"
    }

    object Lombok {
        const val VERSION = "1.18.20"
        const val NOTATION = "org.projectlombok:lombok:$VERSION"
    }

    object Jupiter {
        const val VERSION = "5.8.1"

        object Api {
            const val NOTATION = "org.junit.jupiter:junit-jupiter-api:$VERSION"
        }

        object Engine {
            const val NOTATION = "org.junit.jupiter:junit-jupiter-engine:$VERSION"
        }
    }

    /** Springboot-starter-xxx */
    object SpringBoot {
        const val VERSION = "2.5.5"

        // org.springframework.boot:spring-boot-starter-data-redis-reactive
        object DataRedis {
            const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-data-redis-reactive"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }

        object DataR2dbc {
            const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-data-r2dbc"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }

        object Aop {
            const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-aop"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }

        object Web {
            const val VERSION = "5.3.10"
            const val NOTATION_NOV = "org.springframework:spring-web"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }

        // implementation("org.springframework.boot:spring-boot-starter-webflux:2.5.5")
        object Webflux {
            const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-webflux"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }

        // annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.5.5")
        object ConfigurationProcessor {
            const val NOTATION_NOV = "org.springframework.boot:spring-boot-configuration-processor"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }


    }

    /*
        implementation("io.r2dbc:r2dbc-pool:0.8.7.RELEASE")
        implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE") // 0.8.2.
    */

    object R2dbc {
        object Pool {
            const val VERSION = "0.8.7.RELEASE"
            const val NOTATION = "io.r2dbc:r2dbc-pool:$VERSION"
        }

        object Mysql {
            const val VERSION = "0.8.2.RELEASE"
            const val NOTATION = "dev.miku:r2dbc-mysql:$VERSION"
        }
    }


}



