@file:Suppress("UnstableApiUsage")

plugins {
    id("primer_android_hilt_lib")
}
android {
    namespace = "com.mukul.jan.primer.flavor.friend.list"
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(project(":feature-friend-list"))
    implementation(project(":base-ui"))

    platform(libs.android.compose.bom)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.android.compose)
}