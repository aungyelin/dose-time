import dev.yelinaung.dosetime.DoseBuildType

plugins {
    alias(libs.plugins.dosetime.android.application)
    alias(libs.plugins.dosetime.android.application.compose)
    alias(libs.plugins.dosetime.hilt)
    alias(libs.plugins.dosetime.kotlin.serialization)
}

android {
    namespace = "dev.yelinaung.dosetime"

    defaultConfig {
        applicationId = "dev.yelinaung.dosetime"
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            applicationIdSuffix = DoseBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = false
            applicationIdSuffix = DoseBuildType.RELEASE.applicationIdSuffix

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {

    implementation(projects.core.common)
    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.model)

    implementation(projects.feature.onboarding)
    implementation(projects.feature.main)
    implementation(projects.feature.home)
    implementation(projects.feature.medications)
    implementation(projects.feature.details)
    implementation(projects.feature.addmed)

    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.androidx.navigation.compose)
    androidTestImplementation(libs.androidx.navigation.testing)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}