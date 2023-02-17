plugins {
    id("primer_android_hilt_lib")
    id("io.realm.kotlin")
}
android {
    namespace = "com.mukul.jan.primer.data.login.api"
}
dependencies {
    api(project(":base-network"))
    api(project(":base-database"))
    implementation(project(":common"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.android.coroutines)
    implementation(libs.realm.sync)
}