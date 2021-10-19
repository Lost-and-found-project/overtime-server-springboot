import org.gradle.api.Project


/**
 * 寻找同级目录的项目, 例如与 `domain` 同级的 `service`
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Project.findServicesSameLevel(name: String): Project? {

    val id = parent!!.name
    return parent!!.childProjects["$id-$name"]
}
