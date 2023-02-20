plugins {
    id("primer_android_hilt_lib")
    id("io.realm.kotlin")
}
android {
    namespace = "com.mukul.jan.primer.data.login.impl"
}
dependencies {
    implementation(project(":common"))
    implementation(project(":data-login:api"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.realm.sync)
}