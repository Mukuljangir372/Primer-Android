package com.mukul.jan.primerandroid.flavor

import android.app.Activity
import com.mukul.jan.primerandroid.BuildConfig

data class Flavor(
    val name: String,
    val rootEntry: String,
)

class FlavorContainer {
    private val base = "com.mukul.jan.primer.flavor"
    private val flavors = listOf(
        Flavor(name = "full", rootEntry = "$base.full.RootEntry"),
        Flavor(name = "login", rootEntry = "$base.login.RootEntry"),
        Flavor(name = "onboarding", rootEntry = "$base.onboarding.RootEntry"),
        Flavor(name = "chatList", rootEntry = "$base.chat.list.RootEntry"),
        Flavor(name = "fileList", rootEntry = "$base.file.list.RootEntry"),
        Flavor(name = "friendList", rootEntry = "$base.friend.list.RootEntry"),
        Flavor(name = "notificationList", rootEntry = "$base.notification.list.RootEntry"),
        Flavor(name = "settings", rootEntry = "$base.settings.RootEntry"),
    )

    fun startFlavorEntry(activity: Activity) {
        val buildFlavor = BuildConfig.FLAVOR
        val actualFlavor = buildFlavor.removePrefix("dev").removePrefix("prod")
        val flavor = flavors.first {
            it.name.contains(actualFlavor, ignoreCase = true)
        }

        val clazz = Class.forName(flavor.rootEntry)
        val clazzConstructor = clazz.getConstructor(Activity::class.java)
        val obj = clazzConstructor.newInstance(activity)
        val entryMethod = clazz.getMethod("enter")
        entryMethod.invoke(obj)
    }
}