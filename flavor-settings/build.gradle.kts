@file:Suppress("UnstableApiUsage")

plugins {
    id("primer_android_hilt_lib")
}
android {
    namespace = "com.mukul.jan.primer.flavor.settings"
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(project(":base-ui"))
    implementation(project(":feature-settings"))

    platform(libs.android.compose.bom)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.android.compose)
}