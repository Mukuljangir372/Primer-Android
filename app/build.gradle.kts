@file:Suppress("UnstableApiUsage")

import com.mu.jan.primerandroid.build.logic.configureAppDefaultConfigs
import com.mu.jan.primerandroid.build.logic.configureProductFlavors

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.mukul.jan.primerandroid"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mukul.jan.primerandroid"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        configureAppDefaultConfigs(project)
    }

    configureProductFlavors(project)

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0-alpha01"
    }
    testOptions {
        animationsDisabled = true
    }
    packagingOptions {
        resources.excludes.addAll(listOf("META-INF/*"))
    }
}
kapt {
    correctErrorTypes = true
}
dependencies {
    implementation(project(":common"))

    platform(libs.android.compose.bom)
    implementation(libs.bundles.androidx.ktx)
    implementation(libs.android.hilt)
    kapt(libs.android.hilt.compiler)
    implementation(libs.android.coroutines.core)
    implementation(libs.bundles.android.compose)
    debugImplementation(libs.bundles.android.compose.debug)
}