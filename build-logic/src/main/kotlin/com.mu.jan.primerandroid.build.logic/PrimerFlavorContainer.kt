package com.mu.jan.primerandroid.build.logic

data class ProductFlavor(
    val name: String, //name of the flavor
    val module: String, //flavor depend on which module
    val useSeparatePackage: Boolean, //install a separate apk if true
)

class PrimerFlavorContainer {
    fun getPrimerFlavors(): List<ProductFlavor> {
        return listOf(
            ProductFlavor(
                name = "full",
                module = ":flavor-full",
                useSeparatePackage = false,
            ),
            ProductFlavor(
                name = "onboarding",
                module = ":flavor-onboarding",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "login",
                module = ":flavor-login",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "chat-list",
                module = ":flavor-chat-list",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "file-list",
                module = ":flavor-file-list",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "friend-list",
                module = ":flavor-friend-list",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "notification-list",
                module = ":flavor-notification-list",
                useSeparatePackage = true,
            ),
        )
    }
}