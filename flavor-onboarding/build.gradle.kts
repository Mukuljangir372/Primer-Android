plugins {
    id("primer_android_lib")
}
android {
    namespace = "com.mukul.jan.primer.flavor.onboarding"
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(project(":feature-onboarding"))
}