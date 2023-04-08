@file:Suppress("UnstableApiUsage")

plugins {
    id("primer_android_hilt_lib")
}
android {
    namespace = "com.mukul.jan.primer.flavor.full"
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(project(":base-ui"))
    implementation(project(":feature-dashboard"))
    implementation(project(":feature-server-list"))
    implementation(project(":feature-file-list"))
    implementation(project(":feature-friend-list"))
    implementation(project(":feature-login"))
    implementation(project(":feature-notification-list"))
    implementation(project(":feature-onboarding"))
    implementation(project(":feature-settings"))

    platform(libs.android.compose.bom)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.android.compose)
}