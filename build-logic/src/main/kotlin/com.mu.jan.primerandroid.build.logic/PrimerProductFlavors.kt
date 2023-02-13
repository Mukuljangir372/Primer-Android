package com.mu.jan.primerandroid.build.logic

internal data class ProductFlavor(
    val name: String, //name of the flavor
    val module: String, //flavor depend on which module
    val useSeparatePackage: Boolean, //install a separate apk if true
)

internal fun getPrimerFlavors(): List<ProductFlavor> {
    return listOf(
        ProductFlavor(name = "full", module = ":flavor-full", useSeparatePackage = false),
        ProductFlavor(name = "onboarding", module = ":flavor-onboarding", useSeparatePackage = true)
    )
}