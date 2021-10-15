rootProject.name = "overtime-server-springboot"
include("overtime-utils")
include("overtime-application")
include("overtime-domain-common")
include("overtime-common")

// include("services")
// val services = project(":services")
// services subProjects
// include("services:compensate")
// include("services:compensate:domain")

val subNames =
    listOf("domain", "repository", "resources", "service", "service-impl", "controller")

includes("services") {
    // 补偿相关模块
    sub("compensate") {
        subs()
        // sub("domain")
        // sub("repository")
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
        if(ignoreIfNotExists) {
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
    subNames.forEach {
        sub(it, ignoreIfNotExists)
    }
}