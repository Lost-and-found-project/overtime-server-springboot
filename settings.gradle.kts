rootProject.name = "overtime-server-springboot"

// include("overtime-application")
// include("overtime-gateway")
includes("overtime-configuration") {
    sub("configuration-handler") // 异常处理、响应值处理
    sub("configuration-dataSource") // 数据源配置
}

includes("overtime-common") {
    sub("common-core")
    sub("common-domain")
    sub("common-service")
    sub("common-controller")
}

include("overtime-application")
include("overtime-gateway")

val modules = listOf(
    "domain", "repository",
    "service", "service-impl",
    "api", "controller"
)

includes("services") {
    // 字典模块
    sub("dictionary") { subs() }
    // 补偿模块
    sub("compensate") { subs() }
    // 用户模块
    sub("user") { subs() }
}
println()

println("================================")
println("================================")
println()


println()
println("================================")
println("================================")


////////////////
@kotlin.DslMarker
annotation class IncDsl

@kotlin.DslMarker
annotation class IncOuterDsl

class Include(parentPath: String?, path: String) {
    private val path: String =
        if (parentPath != null) "$parentPath:$path" else path
    private val name: String =
        if (parentPath != null) "$parentPath-$path" else path

    @Suppress("NOTHING_TO_INLINE")
    fun doInc(ignoreIfNotExists: Boolean = false) {
        if (ignoreIfNotExists) {
            kotlin.runCatching {
                include(path)
            }.getOrElse {
                println("> [Warn]: Include $path failed: ${it.localizedMessage}")
            }
        } else {
            include(path)
        }
        println("> Include $path")
        val p = project(":$path")
        println(">> Project: $p")
        println(">> Project.name: ${p.name}")
        println(">> Name: $name")
        println()
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
fun Include.subs(ignoreIfNotExists: Boolean = false) {
    // sub("domain", ignoreIfNotExists)
    // sub("repository", ignoreIfNotExists)
    modules.forEach {
        sub(it, ignoreIfNotExists)
    }
}

