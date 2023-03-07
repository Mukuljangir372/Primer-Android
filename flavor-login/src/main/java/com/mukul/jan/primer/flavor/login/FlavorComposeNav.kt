package com.mukul.jan.primer.flavor.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mukul.jan.primer.feature.login.navigation.LoginNav

@Composable
internal fun FlavorComposeNav(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = LoginNav.getRootRoute()
    ) {
        LoginNav.addLoginNavAtTopLevel(
            navController = navController,
            graph = this
        )
    }
}