plugins {
    alias(libs.plugins.dosetime.android.feature)
}

android {
    namespace = "dev.yelinaung.dosetime.feature.main"
}

dependencies {

    implementation(projects.feature.home)
    implementation(projects.feature.medications)
    implementation(projects.feature.details)
    implementation(projects.feature.addmed)

}