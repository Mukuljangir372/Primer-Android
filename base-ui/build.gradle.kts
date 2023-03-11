plugins {
    id("primer_android_lib")
}
android {
    namespace = "com.mukul.jan.primer.base.ui"
    buildFeatures {
        compose = true
    }
}
dependencies {
    platform(libs.android.compose.bom)
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.android.compose)
    implementation(libs.bundles.android.accompanist)
}