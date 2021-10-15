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
    object SBStarter {
        const val VERSION = "2.5.5"
        object DataR2dbc {
            const val NOTATION = "org.springframework.boot:spring-boot-starter-data-r2dbc:$VERSION"
        }
        object Aop {
            const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-aop"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }
    }



}



