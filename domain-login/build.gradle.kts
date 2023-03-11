plugins {
    id("primer_android_hilt_lib")
}
android {
    namespace = "com.mukul.jan.primer.domain.login"
}
dependencies {
    api(project(":data-login:api"))
    api(project(":data-login:impl"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.android.coroutines.core)
}