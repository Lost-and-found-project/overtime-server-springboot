@file:Suppress("NOTHING_TO_INLINE")

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

/**
 * 依赖统一版本控制
 *
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
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
    object Spring {
        const val VERSION = "5.3.10"

        // Spring-web
        object Web {
            const val NOTATION_NOV = "org.springframework:spring-web"
            const val NOTATION = "$NOTATION_NOV:$VERSION"
        }

        /**
         * Spring-boot相关启动器依赖
         */
        object Boot {
            const val VERSION = "2.5.5"

            object Data {

                object Commons {
                    const val NOTATION_NOV = "org.springframework.data:spring-data-commons"
                    const val NOTATION = "$NOTATION_NOV:$VERSION"
                }

                // org.springframework.boot:spring-boot-starter-data-redis-reactive
                object Redis {
                    const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-data-redis-reactive"
                    const val NOTATION = "$NOTATION_NOV:$VERSION"
                }

                object R2dbc {
                    const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-data-r2dbc"
                    const val NOTATION = "$NOTATION_NOV:$VERSION"
                }

            }

            object Aop {
                const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-aop"
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


        /**
         * Spring-cloud 相关依赖
         */
        object Cloud {
            const val VERSION = "2020.0.4"
            const val GROUP_ID = "org.springframework.cloud"

            /*
                dependencyManagement {
                  imports {
                    mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
                  }
                }
             */
            object Dependencies {
                const val NOTATION = "$GROUP_ID:spring-cloud-dependencies:$VERSION"
            }

            object Gateway {
                const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-gateway"
            }

            object Openfeign {
                const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-openfeign"
            }

            object Loadbalancer {
                const val NOTATION_NOV = "$GROUP_ID:spring-cloud-loadbalancer"
            }
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

    object Alibaba {
        object Cloud {
            const val GROUP_ID = "com.alibaba.cloud"

            object Dependencies {
                const val VERSION = "2021.1"
                const val NOTATION = "$GROUP_ID:spring-cloud-alibaba-dependencies:$VERSION"
            }

            object Nacos {
                object Discovery {
                    const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-alibaba-nacos-discovery"
                }

                object Config {
                    const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-alibaba-nacos-config"
                }
            }
        }
    }
}


inline fun DependencyHandler.configProject(id: String) = project(":overtime-configuration:configuration-$id")
inline fun DependencyHandler.commonProject(id: String) = project(":overtime-common:common-$id")
inline fun DependencyHandler.serviceProject(id: String, module: String) = project(":services:$id:$module")

