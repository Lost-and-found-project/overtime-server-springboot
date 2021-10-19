rootProject.name = "overtime-server-springboot"



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

val modules =
    listOf(
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
    val path: String = if (parentPath != null) "$parentPath:$path" else path
    // val name: String = if (parentPath != null) "$parentPath-$path" else path

    @Suppress("NOTHING_TO_INLINE")
    inline fun doInc(ignoreIfNotExists: Boolean = false) {
        if (ignoreIfNotExists) {
            kotlin.runCatching {
                include(path).run {
                    println(" >>>> '$path' BuildFileName: " + project(path).buildFileName)
                    println(" >>>> '$path' name: " + project(path).name)
                }
            }.getOrElse {
                println("> [Warn]: Include $path failed: ${it.localizedMessage}")
            }
        } else {
            include(path).run {
                println(" >>>> '$path' BuildFileName: " + project(path).buildFileName)
                println(" >>>> '$path' name: " + project(path).name)
            }
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
inline fun includes(id: String, block: (Include.() -> Unit) = {}) {
    val inc = Include(null, id)
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

