package com.mukul.jan.primer.feature.dashboard.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mukul.jan.primer.feature.dashboard.DashboardScreenUtils

object DashboardNav {
    val root = Screen.Dashboard

    sealed class Screen(val route: String) {
        object Dashboard : Screen(route = "dashboard")
    }

    sealed class NavScreen(val route: String) {
        fun createRoute(root: Screen) = "${root.route}/$route"

        object Server : NavScreen(route = "server")
        object FriendList : NavScreen(route = "friendList")
        object FileList : NavScreen(route = "fileList")
        object NotificationList : NavScreen(route = "notificationList")
        object Settings : NavScreen(route = "settings")
    }

    fun addAtTopLevel(
        graph: NavGraphBuilder,
        serverScreen: @Composable () -> Unit,
        friendListScreen: @Composable () -> Unit,
        fileListScreen: @Composable () -> Unit,
        notificationListScreen: @Composable () -> Unit,
        settingsScreen: @Composable () -> Unit
    ) {
        graph.apply {
            navigation(
                route = root.route, startDestination = NavScreen.Server.createRoute(root)
            ) {
                composable(NavScreen.Server.createRoute(root)) {
                    serverScreen.invoke()
                }
                composable(NavScreen.FriendList.createRoute(root)) {
                    friendListScreen.invoke()
                }
                composable(NavScreen.FileList.createRoute(root)) {
                    fileListScreen.invoke()
                }
                composable(NavScreen.NotificationList.createRoute(root)) {
                    notificationListScreen.invoke()
                }
                composable(NavScreen.Settings.createRoute(root)) {
                    settingsScreen.invoke()
                }
            }
        }
    }

    fun navigate(controller: NavHostController, id: Int) {
        fun NavOptionsBuilder.popStack() {
            popUpTo(controller.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
        when (id) {
            DashboardScreenUtils.BottomNav.chat.id -> {
                controller.navigate(NavScreen.Server.createRoute(root)) {
                    popStack()
                }
            }
            DashboardScreenUtils.BottomNav.friends.id -> {
                controller.navigate(NavScreen.FriendList.createRoute(root)) {
                    popStack()
                }
            }
            DashboardScreenUtils.BottomNav.files.id -> {
                controller.navigate(NavScreen.FileList.createRoute(root)) {
                    popStack()
                }
            }
            DashboardScreenUtils.BottomNav.notifications.id -> {
                controller.navigate(NavScreen.NotificationList.createRoute(root)) {
                    popStack()
                }
            }
            DashboardScreenUtils.BottomNav.settings.id -> {
                controller.navigate(NavScreen.Settings.createRoute(root)) {
                    popStack()
                }
            }
        }
    }
}