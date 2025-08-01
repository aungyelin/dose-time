import androidx.room.gradle.RoomExtension
import com.google.devtools.ksp.gradle.KspExtension
import dev.yelinaung.dosetime.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {

        with(target) {

            with(pluginManager) {
                apply("androidx.room")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<KspExtension> {
                arg("room.generateKotlin", "true")
            }

            extensions.configure<RoomExtension> {
                // The schemas directory contains a schema file for each version of the Room database.
                // This is required to enable Room auto migrations.
                // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                add("implementation", libs.findLibrary("androidx.room.runtime").get())
                add("ksp", libs.findLibrary("androidx.room.compiler").get())
                add("implementation", libs.findLibrary("androidx.room.ktx").get())
                add("implementation", libs.findLibrary("androidx.room.paging").get())

                add("testImplementation", libs.findLibrary("androidx.room.testing").get())
            }

        }

    }

}
