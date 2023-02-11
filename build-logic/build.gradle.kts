plugins {
    `kotlin-dsl`
}
repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}
dependencies {
    implementation(libs.kotlin.gradle)
    implementation(libs.gradle)
    compileOnly(gradleApi())
}
gradlePlugin {
    plugins {
        fun create(id: String, className: String) {
            plugins.create(id) {
                this.id = id
                implementationClass = className
            }
        }
        create(
            id = "primer_android_lib",
            className = "com.mu.jan.primerandroid.build.logic.PrimerAndroidLibPlugin"
        )
    }
}