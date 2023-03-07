package com.mukul.jan.primerandroid.flavor

data class Flavor(
    val name: String,
    val entry: String,
    val moduleName: String,
)

class FlavorContainer {
    val flavors = listOf<Flavor>()
    fun start() {

    }
}