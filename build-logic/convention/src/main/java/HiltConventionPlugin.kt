import com.android.build.gradle.api.AndroidBasePlugin
import dev.yelinaung.dosetime.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                add("ksp", libs.findLibrary("hilt.compiler").get())
            }

            pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {

                dependencies {
                    add("implementation", libs.findLibrary("hilt.core").get())

                    add("testImplementation", libs.findLibrary("hilt.android.testing").get())
                    add("kspTest", libs.findLibrary("hilt.compiler").get())
                }

            }

            /**
             * Add support for Android modules, based on [AndroidBasePlugin]
             * */
            pluginManager.withPlugin("com.android.base") {

                apply(plugin = "com.google.dagger.hilt.android")

                dependencies {
                    add("implementation", libs.findLibrary("hilt.android").get())

                    add("androidTestImplementation", libs.findLibrary("hilt.android.testing").get())
                    add("kspAndroidTest", libs.findLibrary("hilt.compiler").get())
                }

            }

        }

    }

}