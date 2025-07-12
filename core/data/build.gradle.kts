plugins {
    alias(libs.plugins.dosetime.android.library)
    alias(libs.plugins.dosetime.hilt)
}

android {
    namespace = "dev.yelinaung.dosetime.core.data"
}

dependencies {

    implementation(projects.core.domain)

    implementation(projects.core.database)
    implementation(projects.core.datastore)

}