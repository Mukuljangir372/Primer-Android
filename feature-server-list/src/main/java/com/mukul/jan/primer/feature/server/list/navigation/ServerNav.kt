package com.mukul.jan.primer.feature.server.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mukul.jan.primer.feature.server.list.PrimaryServerScreen

object ServerNav {
    val root = Screen.Server

    sealed class Screen(val route: String) {
        object Server : Screen(route = "server")
    }

    sealed class NavScreen(val route: String) {
        fun createRoute(root: Screen) = "${root.route}/$route"

        object Primary : NavScreen(route = "primary")
    }

    fun addAtTopLevel(navController: NavHostController, graph: NavGraphBuilder) {
        graph.apply {
            navigation(
                route = root.route,
                startDestination = NavScreen.Primary.createRoute(root)
            ) {
                composable(NavScreen.Primary.createRoute(root)) {
                    PrimaryServerScreen()
                }
            }
        }
    }
}