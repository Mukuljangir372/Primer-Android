plugins {
    id("primer_android_lib")
}
android {
    namespace = "com.mukul.jan.primer.flavor.login"
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(project(":feature-login"))
}