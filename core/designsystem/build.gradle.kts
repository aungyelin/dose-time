plugins {
    alias(libs.plugins.dosetime.android.library)
    alias(libs.plugins.dosetime.android.library.compose)
}

android {
    namespace = "dev.yelinaung.dosetime.core.designsystem"
}

dependencies {

    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.coil.compose)

}