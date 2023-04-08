package com.mukul.jan.primer.feature.chat.list.navigation

object ChatNav {
    sealed class Screen(val route: String) {
        object Dashboard : Screen(route = "chatDashboard")
    }

    sealed class NavScreen(val route: String) {
        fun createRoute(root: Screen) = "${root.route}/$route"
    }

    fun addAtTopLevel() {

    }
}