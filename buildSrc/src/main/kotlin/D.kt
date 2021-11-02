@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate")

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

@Suppress("PropertyName")
abstract class DependencyNotation(val groupId: String, val name: String, val version: String? = null) {
    inline val NOTATION: String get() = if (version != null) "$groupId:$name:$version" else "$groupId:$name"
    inline val NOTATION_NOV: String get() = "$groupId:$name"
    override fun toString(): String = "DependencyNotation(notation=$NOTATION)"
}

/**
 * 依赖统一版本控制
 *
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
object D {
    object JetbrainsAnnotation : DependencyNotation("org.jetbrains", "annotations", "22.0.0")
    object Lombok : DependencyNotation("org.projectlombok", "lombok", "1.18.20")


    sealed class Jupiter(name: String) : DependencyNotation("org.junit.jupiter", name, VERSION) {
        companion object {
            const val VERSION = "5.8.1"
        }

        object Api : Jupiter("junit-jupiter-api")
        object Engine : Jupiter("junit-jupiter-engine")
    }


    sealed class Reactor(name: String) : DependencyNotation("io.projectreactor", "reactor-$name", null) {
        object Test : Reactor("test")
    }

    sealed class Springfox(name: String) : DependencyNotation("io.springfox", name, VERSION) {
        companion object {
            const val VERSION = "3.0.0"
        }
    }

    // Spring
    sealed class Spring(name: String) : DependencyNotation("org.springframework", name, VERSION) {
        companion object {
            const val VERSION = "5.3.10"
        }

        // Spring-web
        object Web : Spring("spring-web")

        /**
         * Spring-boot相关启动器依赖
         */
        // Springboot-starter-xxx
        sealed class Boot(groupId: String, name: String, version: String? = VERSION) :
            DependencyNotation(groupId, name, version) {
            constructor(name: String, version: String? = VERSION) : this(groupId = "org.springframework.boot",
                name = name,
                version = version)

            companion object {
                const val VERSION = "2.5.5"
            }


            sealed class Data(name: String, version: String? = VERSION) :
                Boot("org.springframework.data", name, version) {
                object Commons : Data("spring-data-commons", "2.5.5") // maybe not follow boot version.

                ///// From Boot, but is data like.
                // org.springframework.boot:spring-boot-starter-data-redis-reactive
                object Redis : Boot("spring-boot-starter-data-redis-reactive")
                // const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-data-redis-reactive"

                object R2dbc : Boot("spring-boot-starter-data-r2dbc")
                // const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-data-r2dbc"

            }

            object Test : Boot("spring-boot-starter-test")


            object Actuator : Boot("spring-boot-starter-actuator")


            object Aop : Boot("spring-boot-starter-aop")
            // const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-aop"


            object Web : Boot("spring-boot-starter-web")


            // implementation("org.springframework.boot:spring-boot-starter-webflux:2.5.5")
            object Webflux : Boot("spring-boot-starter-webflux")
            // const val NOTATION_NOV = "org.springframework.boot:spring-boot-starter-webflux"

            object Autoconfigure : Boot("spring-boot-autoconfigure")

            // annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:2.5.5")
            object ConfigurationProcessor : Boot("spring-boot-configuration-processor")
            // const val NOTATION_NOV = "org.springframework.boot:spring-boot-configuration-processor"

        }


        /**
         * Spring-cloud 相关依赖
         */
        sealed class Cloud(name: String) : DependencyNotation(GROUP_ID, name, VERSION) {
            companion object {
                const val VERSION = "2020.0.4"
                const val GROUP_ID = "org.springframework.cloud"
            }

            /*
                dependencyManagement {
                  imports {
                    mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
                  }
                }
             */
            object Dependencies : Cloud("spring-cloud-dependencies")
            // const val NOTATION = "$GROUP_ID:spring-cloud-dependencies:$VERSION"

            // Enable bootstrap config file support.
            object Bootstrap : Cloud("spring-cloud-starter-bootstrap")

            object Gateway : Cloud("spring-cloud-starter-gateway")
            // const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-gateway"


            // see https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#reactive-support
            // Use https://github.com/Playtika/feign-reactive to support spring webflux
            /**
             * 暂不支持 Reactive. 使用 [FeignReactor].
             * @see FeignReactor
             */
            @Deprecated("Use Feign.Reactor", replaceWith = ReplaceWith("D.FeignReactor.SpringConfiguration"))
            object Openfeign : Cloud("spring-cloud-starter-openfeign")
            // const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-openfeign"


            object Loadbalancer : Cloud("spring-cloud-loadbalancer")
            // const val NOTATION_NOV = "$GROUP_ID:spring-cloud-loadbalancer"
        }
    }

    // see https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/#reactive-support
    // Use https://github.com/Playtika/feign-reactive to support spring webflux
    sealed class FeignReactor(name: String) : DependencyNotation(GROUP_ID, name, VERSION) {
        companion object {
            const val VERSION = "3.0.3"
            const val GROUP_ID = "com.playtika.reactivefeign"
        }


        object WebClient : FeignReactor("feign-reactor-webclient")
        // const val NOTATION = "$GROUP_ID::$VERSION"


        object Cloud : FeignReactor("feign-reactor-cloud")
        // const val NOTATION = "$GROUP_ID:feign-reactor-cloud:$VERSION"

        object SpringConfiguration : FeignReactor("feign-reactor-spring-configuration")
        // const val NOTATION = "$GROUP_ID:feign-reactor-spring-configuration:$VERSION"
    }

    // object OpenFeign {
    /*
     <dependency>
        <groupId>io.github.openfeign</groupId>
        <artifactId>feign-slf4j</artifactId>
        <version>11.2</version>
    </dependency
     */
    // }

    /*
        implementation("io.r2dbc:r2dbc-pool:0.8.7.RELEASE")
        implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE") // 0.8.2.
    */

    object R2dbc {
        object Pool : DependencyNotation("io.r2dbc", "r2dbc-pool", "0.8.7.RELEASE")
        // const val VERSION = "0.8.7.RELEASE"
        // const val NOTATION = "io.r2dbc:r2dbc-pool:$VERSION"


        object Mysql : DependencyNotation("dev.miku", "r2dbc-mysql", "0.8.2.RELEASE")
        // const val VERSION = "0.8.2.RELEASE"
        // const val NOTATION = "dev.miku:r2dbc-mysql:$VERSION"

    }

    sealed class Alibaba(groupId: String, name: String, version: String?) : DependencyNotation(groupId, name, version) {
        sealed class Cloud(name: String) : Alibaba(GROUP_ID, name, VERSION) {
            companion object {
                const val VERSION = "2021.1"
                const val GROUP_ID = "com.alibaba.cloud"
            }

            object Dependencies : Cloud("spring-cloud-alibaba-dependencies")
            // const val NOTATION = "$GROUP_ID:spring-cloud-alibaba-dependencies:$VERSION"


            sealed class Nacos(name: String) : Cloud(name) {
                object Discovery : Nacos("spring-cloud-starter-alibaba-nacos-discovery") {
                    const val MODULE = "spring-cloud-starter-alibaba-nacos-discovery"
                }
                // const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-alibaba-nacos-discovery"


                object Config : Nacos("spring-cloud-starter-alibaba-nacos-config") {
                    const val MODULE = "spring-cloud-starter-alibaba-nacos-config"
                }
                // const val NOTATION_NOV = "$GROUP_ID:spring-cloud-starter-alibaba-nacos-config"

            }
        }
    }

    /**
     * Jwt 实现
     */
    sealed class Jwt(groupId: String, name: String, version: String) : DependencyNotation(groupId, name, version) {

        /**
         * see https://github.com/auth0/java-jwt
         */
        object JavaJwt : Jwt("com.auth0", "java-jwt", "3.18.2")
        sealed class Jjwt(name: String) : Jwt("io.jsonwebtoken", "jjwt-$name", VERSION) {
            companion object {
                const val VERSION = "0.11.2"
            }


            object Api : Jjwt("api")
            object Impl : Jjwt("impl") // runtimeOnly
            object Jackson : Jjwt("jackson") // runtimeOnly
            object Gson : Jjwt("gson") // runtimeOnly

        }

    }

    /**
     * https://querydsl.com/
     */
    sealed class Querydsl(name: String) : DependencyNotation(GROUP_ID, "querydsl-sql-$name", VERSION) {
        companion object {
            const val GROUP_ID = "com.querydsl"
            const val VERSION = "5.0.0"
        }

        object Spring : Querydsl("spring")
    }


}


inline fun DependencyHandler.configProject(id: String) = project(":overtime-configuration:configuration-$id")
inline fun DependencyHandler.commonProject(id: String) = project(":overtime-common:common-$id")
inline fun DependencyHandler.serviceProject(id: String, module: String) = project(":services:$id:$id-$module")

