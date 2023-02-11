@file:Suppress("UnstableApiUsage")

rootProject.name = "build-logic"
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}