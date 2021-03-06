rootProject.name = "overtime-server-springboot"

// include("overtime-application")
// include("overtime-gateway")
includes("overtime-configuration") {
    sub("configuration-handler") // 异常处理、响应值处理
    sub("configuration-r2dbc-template") // r2dbc template.
    sub("configuration-security") // webflux security
}

includes("overtime-admins") {
    sub("overtime-admin-domain")
    sub("overtime-admin-api")
    sub("overtime-admin-application")
}

includes("overtime-common") {
    sub("common-core")
    sub("common-domain")
    sub("common-service")
    sub("common-repository")
    sub("common-application")
    sub("common-authentication")
    sub("common-jwt")
}

include("overtime-gateway")

val modules = listOf(
    "domain", "repository",
    "service", "service-impl",
    "api", "controller", "application"
)

includes("services") {
    // 加班模块
    sub("overtime") { serviceSubs() }
    // 字典模块
    sub("dictionary") { serviceSubs() }
    // 补偿模块
    sub("compensate") { serviceSubs() }
    // 用户模块
    sub("user") { serviceSubs() }
}

include("overtime-application")
include("overtime-admin")

println()


////////////////
@DslMarker
annotation class IncDsl

@DslMarker
annotation class IncOuterDsl

class Include(parentPath: String?, val id: String) {
    private val path: String =
        if (parentPath != null) "$parentPath:$id" else id

    @Suppress("NOTHING_TO_INLINE")
    fun doInc(ignoreIfNotExists: Boolean = false) {
        if (ignoreIfNotExists) {
            kotlin.runCatching {
                include(path)
            }.getOrElse {
                println("> [Warn]: Include $path failed: $it")
            }
        } else {
            include(path)
        }
        println("> Include $path")
        // val p = project(":$path")
        // p.name = name
    }


    @IncDsl
    @Suppress("NOTHING_TO_INLINE")
    fun sub(path: String, ignoreIfNotExists: Boolean = false, block: (Include.() -> Unit) = {}) {
        val inc = Include(this.path, path)
        inc.doInc(ignoreIfNotExists)
        block(inc)
    }
}

@IncOuterDsl
@Suppress("NOTHING_TO_INLINE")
fun includes(id: String, block: (Include.() -> Unit) = {}) {
    val inc = Include(null, id)
    inc.doInc()
    block(inc)
}


@IncOuterDsl
@Suppress("NOTHING_TO_INLINE")
fun Include.serviceSubs(ignoreIfNotExists: Boolean = false) {
    modules.forEach {
        sub("$id-$it", ignoreIfNotExists)
    }
}
