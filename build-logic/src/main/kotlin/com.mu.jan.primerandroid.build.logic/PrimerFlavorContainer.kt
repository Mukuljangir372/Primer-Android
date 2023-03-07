package com.mu.jan.primerandroid.build.logic

data class ProductFlavor(
    val name: String, //name of the flavor
    val module: String, //flavor depend on which module
    val useSeparatePackage: Boolean, //install a separate apk if true
    val entry: String, //root entry e.g any activity
)

class PrimerFlavorContainer {
    fun getPrimerFlavors(): List<ProductFlavor> {
        return listOf(
            ProductFlavor(
                name = "full",
                module = ":flavor-full",
                useSeparatePackage = false,
                entry = ""
            ),
            ProductFlavor(
                name = "onboarding",
                module = ":flavor-onboarding",
                useSeparatePackage = true,
                entry = ""
            ),
            ProductFlavor(
                name = "login",
                module = ":flavor-login",
                useSeparatePackage = true,
                entry = "com.mukul.jan.primer.flavor.login.RootEntry"
            ),
        )
    }
}