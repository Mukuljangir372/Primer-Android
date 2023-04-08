package com.mukul.jan.primer.flavor.full

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mukul.jan.primer.base.ui.design.PrimerTheme
import com.mukul.jan.primer.feature.chat.list.PrimaryChatScreen
import com.mukul.jan.primer.feature.dashboard.DashboardScreen
import com.mukul.jan.primer.feature.dashboard.navigation.DashboardNav
import com.mukul.jan.primer.feature.file.store.FileListScreen
import com.mukul.jan.primer.feature.friend.list.FriendListScreen
import com.mukul.jan.primer.feature.notification.list.NotificationListScreen
import com.mukul.jan.primer.feature.settings.SettingsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlavorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PrimerTheme {
                DashboardScreen(content = {
                    NavHost(
                        navController = navController, startDestination = DashboardNav.root.route
                    ) {
                        DashboardNav.addAtTopLevel(graph = this, chatListScreen = {
                            PrimaryChatScreen()
                        }, friendListScreen = {
                            FriendListScreen()
                        }, fileListScreen = {
                            FileListScreen()
                        }, notificationListScreen = {
                            NotificationListScreen()
                        }, settingsScreen = {
                            SettingsScreen()
                        })
                    }
                }, onSelectBottomNavItem = {
                    DashboardNav.navigate(
                        controller = navController, id = it
                    )
                })
            }
        }
    }
}