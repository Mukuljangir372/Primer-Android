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

include(":base")
include(":base-ui")
include(":base-network")
include(":base-database")
include(":base-preferences")

include(":common-models")

include(":flavor-full")
include(":feature-full")
include(":feature-onboarding")
include(":flavor-onboarding")
