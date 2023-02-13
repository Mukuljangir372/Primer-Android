pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("VERSION_CATALOGS")
includeBuild("build-logic") {
    dependencySubstitution {
        substitute(module("com.mu.jan.primerandroid:build-logic"))
            .using(project(":"))
    }
}

rootProject.name = "PrimerAndroid"
include(":app")
include(":flavor-full")
include(":feature-full")
