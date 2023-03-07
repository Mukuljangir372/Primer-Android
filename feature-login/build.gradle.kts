plugins {
    id("primer_android_hilt_lib")
}
android {
    namespace = "com.mukul.jan.primer.feature.login"
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.android.compose)
    debugImplementation(libs.bundles.android.compose.debug)

    implementation(project(":base-ui"))
    implementation(project(":common-ui"))
}