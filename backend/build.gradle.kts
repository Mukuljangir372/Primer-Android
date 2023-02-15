plugins {
    id("primer_android_lib")
}
android {
    namespace = "com.mukul.jan.primer.backend"
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.realm)
}