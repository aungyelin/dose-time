plugins {
    alias(libs.plugins.dosetime.android.library)
    alias(libs.plugins.dosetime.android.library.compose)
}

android {
    namespace = "dev.yelinaung.dosetime.core.ui"
}

dependencies {

    api(projects.core.designsystem)

}