package com.mukul.jan.primer.feature.full.navigation

object DashboardNav {
    private val root = Screen.Dashboard
    val rootRoute get() = root.route

    sealed class Screen(val route: String) {
        object Dashboard : Screen(route = "dashboard")
    }

    sealed class NavScreen(val route: String) {
        fun createRoute(root: Screen) = "${root.route}/$route"

        object Dashboard : NavScreen(route = "dashboard")

    }


}