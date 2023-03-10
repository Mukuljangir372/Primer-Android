package com.mukul.jan.primerandroid.flavor

import android.app.Activity
import com.mukul.jan.primerandroid.BuildConfig

data class Flavor(
    val name: String,
    val rootEntry: String,
)

class FlavorContainer {
    private val flavors = listOf(
        Flavor(name = "full", rootEntry = ""),
        Flavor(name = "onboarding", rootEntry = ""),
        Flavor(name = "login", rootEntry = "com.mukul.jan.primer.flavor.login.RootEntry"),
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