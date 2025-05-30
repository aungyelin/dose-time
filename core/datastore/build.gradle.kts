plugins {
    alias(libs.plugins.dosetime.android.library)
    alias(libs.plugins.dosetime.hilt)
}

android {
    namespace = "dev.yelinaung.dosetime.core.datastore"

    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
}

dependencies {

    implementation(projects.core.datastoreProto)
    api(projects.core.model)
    implementation(projects.core.common)

    implementation(libs.androidx.dataStore)

}