plugins {
    alias(libs.plugins.dosetime.jvm.library)
    alias(libs.plugins.dosetime.hilt)
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)

    testImplementation(libs.kotlinx.coroutines.test)

}