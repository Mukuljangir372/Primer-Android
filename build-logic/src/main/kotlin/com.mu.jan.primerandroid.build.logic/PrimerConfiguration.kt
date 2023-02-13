package com.mu.jan.primerandroid.build.logic

import com.android.build.api.dsl.VariantDimension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.project

@Suppress("UnstableApiUsage")
fun BaseAppModuleExtension.configureProductFlavors(project: Project) {
    flavorDimensions += listOf("env")
    productFlavors.apply {
        create("dev") {
            dimension = "env"
            extra.set("appIdSuffix", ".dev")
            buildDevConfigFields(project)
        }
        create("prod") {
            dimension = "env"
            extra.set("appIdSuffix", ".prod")
            buildProdConfigFields(project)
        }

        val flavors = getPrimerFlavors()
        if (flavors.isNotEmpty()) {
            flavorDimensions.add("scope")
            flavors.forEach { flavor ->
                create(flavor.name) {
                    dimension = "scope"
                    extra.set("module", flavor.module)
                    if (flavor.name != "full" && flavor.useSeparatePackage) {
                        extra.set("appIdSuffix", ".${flavor.name}")
                    }
                }
            }
        }
    }
    productFlavors.forEach { flavor ->
        if (flavor.extra.has("appIdSuffix") && project.isApplicationProject()) {
            flavor.applicationIdSuffix = flavor.extra.get("appIdSuffix") as String
        }
        if (flavor.dimension == "scope") {
            project.dependencies {
                val module = flavor.extra.get("module") as String
                add("${flavor.name}Api", project(module))
            }
        }
    }
}

internal fun Project.isApplicationProject(): Boolean {
    return name.javaClass.simpleName.startsWith("BaseAppModuleExtension")
}

@Suppress("UnstableApiUsage")
internal fun VariantDimension.buildDevConfigFields(project: Project) {
    buildConfigField("String", "ENV", "\"Dev\"")
}

@Suppress("UnstableApiUsage")
internal fun VariantDimension.buildProdConfigFields(project: Project) {
    buildConfigField("String", "ENV", "\"Prod\"")
}