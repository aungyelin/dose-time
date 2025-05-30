plugins {
    alias(libs.plugins.dosetime.android.feature)
}

android {
    namespace = "dev.yelinaung.dosetime.feature.onboarding"
}

dependencies {

    implementation(projects.core.domain)

}