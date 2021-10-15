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

includes("services") {
    sub("compensate") {
        sub("domain")
    }
}

class Include(parentPath: String?, path: String) {
    val path: String = if (parentPath != null) {
        "$parentPath:$path"
    } else {
        path
    }

    @Suppress("NOTHING_TO_INLINE")
    inline fun doInc() {
        include(path)
        println("Include $path")
    }


    @Suppress("NOTHING_TO_INLINE")
    inline fun sub(path: String, block: (Include.() -> Unit) = {}) {
        val inc = Include(this.path, path)
        inc.doInc()
        block(inc)
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun includes(path: String, block: (Include.() -> Unit) = {}) {
    val inc = Include(null, path)
    inc.doInc()
    block(inc)
}