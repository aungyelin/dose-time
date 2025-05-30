import dev.yelinaung.dosetime.configureKotlinJvm
import dev.yelinaung.dosetime.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class JvmLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
            }

            configureKotlinJvm()

            dependencies {
                add("testImplementation", libs.findLibrary("kotlin.test").get())
            }

        }

    }

}
