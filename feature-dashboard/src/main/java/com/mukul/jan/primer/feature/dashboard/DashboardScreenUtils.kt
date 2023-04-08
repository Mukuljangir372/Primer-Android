package com.mukul.jan.primer.feature.dashboard

import com.mu.jan.primer.common.ui.compose.BottomNavItem
import com.mukul.jan.primer.base.ui.R

object DashboardScreenUtils {
    object BottomNav {
        val chat = BottomNavItem(
            id = 1, label = "chats", icon = null, drawable = R.drawable.baseline_chat_24
        )
        val friends = BottomNavItem(
            id = 2, label = "friends", icon = null, drawable = R.drawable.baseline_groups_24
        )
        val files = BottomNavItem(
            id = 3, label = "files", icon = null, drawable = R.drawable.baseline_cloud_24
        )
        val notifications = BottomNavItem(
            id = 4, label = "notifications", icon = null, drawable = R.drawable.baseline_star_24
        )
        val settings = BottomNavItem(
            id = 5, label = "settings", icon = null, drawable = R.drawable.baseline_person_24
        )
    }

    val bottomNavItems: List<BottomNavItem> = listOf(
        BottomNav.chat,
        BottomNav.friends,
        BottomNav.files,
        BottomNav.notifications,
        BottomNav.settings
    )
}