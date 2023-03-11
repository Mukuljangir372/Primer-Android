plugins {
    id("primer_android_lib")
}
android {
    namespace = "com.mukul.jan.primer.common.ui"
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(project(":base-ui"))

    platform(libs.android.compose.bom)
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.android.compose)
    debugImplementation(libs.bundles.android.compose.debug)
}