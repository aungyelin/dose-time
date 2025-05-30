plugins {
    alias(libs.plugins.dosetime.android.library)
    alias(libs.plugins.dosetime.hilt)
}

android {
    namespace = "dev.yelinaung.dosetime.core.domain"
}

dependencies {

    api(projects.core.model)

}