rootProject.name = "overtime-server-springboot"


include("overtime-application")

includes("overtime-configuration") {
    sub("configuration-handler")
}

includes("overtime-common") {
    sub("common-core")
    sub("common-domain")
    sub("common-service")
}


// include("services")
// val services = project(":services")
// services subProjects
// include("services:compensate")
// include("services:compensate:domain")

val modules =
    listOf(
        "domain", "repository",
        "service", "service-impl",
        "api", "controller"
    )

includes("services") {
    // 补偿相关模块
    sub("compensate") {
        subs()
    }

    // 用户模块
    sub("user") {
        subs()

    }
}
println()

////////////////
@kotlin.DslMarker
annotation class IncDsl

@kotlin.DslMarker
annotation class IncOuterDsl

class Include(parentPath: String?, path: String) {
    val path: String = if (parentPath != null) {
        "$parentPath:$path"
    } else {
        path
    }

    @Suppress("NOTHING_TO_INLINE")
    inline fun doInc(ignoreIfNotExists: Boolean = false) {
        if (ignoreIfNotExists) {
            kotlin.runCatching { include(path) }.getOrElse {
                println("> [Warn]: Include $path failed: ${it.localizedMessage}")
            }
        } else {
            include(path)
        }
        println("> Include $path")
    }


    @IncDsl
    @Suppress("NOTHING_TO_INLINE")
    inline fun sub(path: String, ignoreIfNotExists: Boolean = false, block: (Include.() -> Unit) = {}) {
        val inc = Include(this.path, path)
        inc.doInc(ignoreIfNotExists)
        block(inc)
    }
}

@IncOuterDsl
@Suppress("NOTHING_TO_INLINE")
inline fun includes(path: String, block: (Include.() -> Unit) = {}) {
    val inc = Include(null, path)
    inc.doInc()
    block(inc)
}


@IncOuterDsl
@Suppress("NOTHING_TO_INLINE")
inline fun Include.subs(ignoreIfNotExists: Boolean = false) {
    // sub("domain", ignoreIfNotExists)
    // sub("repository", ignoreIfNotExists)
    modules.forEach {
        sub(it, ignoreIfNotExists)
    }
}
include("overtime-service-common")
include("overtime-gateway")
include("overtime-configuration")
