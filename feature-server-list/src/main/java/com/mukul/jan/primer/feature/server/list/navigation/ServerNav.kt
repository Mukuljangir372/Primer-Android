package com.mukul.jan.primer.feature.server.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mukul.jan.primer.feature.server.list.PrimaryServerScreen
import com.mukul.jan.primer.feature.server.list.channel.ChannelDetailScreen
import com.mukul.jan.primer.feature.server.list.channel.ChannelListScreen
import com.mukul.jan.primer.feature.server.list.chat.ChatScreen
import com.mukul.jan.primer.feature.server.list.club.ClubDetailScreen
import com.mukul.jan.primer.feature.server.list.member.MemberDetailScreen
import com.mukul.jan.primer.feature.server.list.member.MemberListScreen

object ServerNav {
    val root = Screen.Server

    sealed class Screen(val route: String) {
        object Server : Screen(route = "server")
    }

    sealed class NavScreen(val route: String) {
        fun createRoute(root: Screen) = "${root.route}/$route"

        object Primary : NavScreen(route = "primary")
        object ChannelList : NavScreen(route = "channelList")
        object ChannelDetail : NavScreen(route = "channelDetail")
        object Chat : NavScreen(route = "chat")
        object MemberList : NavScreen(route = "memberList")
        object MemberDetail : NavScreen(route = "memberDetail")
        object ClubDetail : NavScreen(route = "clubDetail")
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
                composable(NavScreen.ChannelList.createRoute(root)) {
                    ChannelListScreen()
                }
                composable(NavScreen.ChannelDetail.createRoute(root)) {
                    ChannelDetailScreen()
                }
                composable(NavScreen.Chat.createRoute(root)) {
                    ChatScreen()
                }
                composable(NavScreen.MemberList.createRoute(root)) {
                    MemberListScreen()
                }
                composable(NavScreen.MemberDetail.createRoute(root)) {
                    MemberDetailScreen()
                }
                composable(NavScreen.ClubDetail.createRoute(root)) {
                    ClubDetailScreen()
                }
            }
        }
    }
}