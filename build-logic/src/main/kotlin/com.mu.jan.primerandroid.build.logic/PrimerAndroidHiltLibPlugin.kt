package com.mu.jan.primerandroid.build.logic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class PrimerAndroidHiltLibPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("primer_android_lib")
        target.plugins.apply("com.google.dagger.hilt.android")

        val catalog = target.extensions.getByType<VersionCatalogsExtension>().named("libs")
        target.dependencies {
            add("implementation", (catalog.findLibrary("android_hilt").get()))
            add("implementation", (catalog.findLibrary("android_hilt_nav_compose").get()))
            add("kapt", (catalog.findLibrary("android_hilt_compiler").get()))
        }
    }
}