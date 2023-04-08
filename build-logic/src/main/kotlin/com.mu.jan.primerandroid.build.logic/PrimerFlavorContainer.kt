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
                name = "serverList",
                module = ":flavor-server-list",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "fileList",
                module = ":flavor-file-list",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "friendList",
                module = ":flavor-friend-list",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "notificationList",
                module = ":flavor-notification-list",
                useSeparatePackage = true,
            ),
            ProductFlavor(
                name = "settings",
                module = ":flavor-settings",
                useSeparatePackage = true,
            ),
        )
    }
}