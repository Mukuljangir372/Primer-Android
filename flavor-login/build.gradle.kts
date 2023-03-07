plugins {
    id("primer_android_lib")
}
android {
    namespace = "com.mukul.jan.primer.flavor.login"
    buildFeatures {
        compose = true
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.android.compose)

    implementation(project(":base-ui"))
    implementation(project(":feature-login"))
}