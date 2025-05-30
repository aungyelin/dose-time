import dev.yelinaung.dosetime.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            with(pluginManager) {
                apply("dosetime.android.library")
                apply("dosetime.android.library.compose")
                apply("dosetime.hilt")
                apply("dosetime.kotlin.serialization")
            }

            dependencies {
                add("implementation", project(":core:designsystem"))
                add("implementation", project(":core:domain"))

                add("implementation", libs.findLibrary("androidx.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())

                add("testImplementation", libs.findLibrary("androidx.navigation.testing").get())
            }

        }

    }

}