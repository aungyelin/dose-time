plugins {
    alias(libs.plugins.dosetime.android.library)
    alias(libs.plugins.dosetime.hilt)
    alias(libs.plugins.dosetime.android.room)
}

android {
    namespace = "dev.yelinaung.dosetime.core.database"
}

dependencies {

    api(projects.core.model)

}