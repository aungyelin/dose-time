import com.android.build.api.variant.LibraryAndroidComponentsExtension
import com.android.build.gradle.LibraryExtension
import dev.yelinaung.dosetime.DoseVersions
import dev.yelinaung.dosetime.configureFlavors
import dev.yelinaung.dosetime.configureKotlinAndroid
import dev.yelinaung.dosetime.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = DoseVersions.TARGET_SDK

                //defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                //testOptions.animationsDisabled = true

                configureFlavors(this)
                //configureGradleManagedDevices(this)

                // The resource prefix is derived from the module name,
                // so resources inside ":core:module1" must be prefixed with "core_module1_"
                resourcePrefix = path.split("""\W""".toRegex())
                    .drop(1)
                    .distinct()
                    .joinToString(separator = "_")
                    .lowercase() + "_"
            }

            extensions.configure<LibraryAndroidComponentsExtension> {
                //configurePrintApksTask(this)
                //disableUnnecessaryAndroidTests(target)
            }

            dependencies {
                add("androidTestImplementation", libs.findLibrary("kotlin.test").get())
                add("testImplementation", libs.findLibrary("kotlin.test").get())
            }

        }

    }

}