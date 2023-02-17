package com.mu.jan.primerandroid.build.logic

import ANDROID_COMPILE_SDK_VERSION
import ANDROID_COMPOSE_COMPILER_VERSION
import ANDROID_MIN_SDK_VERSION
import ANDROID_TARGET_SDK_VERSION
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

@Suppress("UnstableApiUsage", "DEPRECATION")
class PrimerAndroidLibPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("com.android.library")
        target.plugins.apply("org.jetbrains.kotlin.android")
        target.plugins.apply("kotlin-android")
        target.plugins.apply("kotlin-kapt")

        target.extensions.getByType(LibraryExtension::class.java).apply {
            compileSdk = target.ANDROID_COMPILE_SDK_VERSION
            defaultConfig {
                minSdk = target.ANDROID_MIN_SDK_VERSION
                targetSdk = target.ANDROID_TARGET_SDK_VERSION
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                targetCompatibility = JavaVersion.VERSION_1_8
                sourceCompatibility = JavaVersion.VERSION_1_8
            }
            composeOptions {
                kotlinCompilerExtensionVersion = target.ANDROID_COMPOSE_COMPILER_VERSION
            }
            testOptions {
                unitTests.isReturnDefaultValues = true
            }
        }

        target.extensions.getByType(KaptExtension::class.java).apply {
            correctErrorTypes = true
        }
    }
}