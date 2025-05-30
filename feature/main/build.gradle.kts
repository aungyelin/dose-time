plugins {
    alias(libs.plugins.dosetime.android.feature)
}

android {
    namespace = "dev.yelinaung.dosetime.feature.main"
}

dependencies {

    implementation(projects.feature.home)
    implementation(projects.feature.history)
    implementation(projects.feature.addmed)

}