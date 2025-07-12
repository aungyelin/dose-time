plugins {
    alias(libs.plugins.dosetime.android.feature)
}

android {
    namespace = "dev.yelinaung.dosetime.feature.home"
}

dependencies {

    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)

}