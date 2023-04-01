package com.mukul.jan.primer.feature.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mukul.jan.primer.feature.login.PrimaryLoginScreen
import com.mukul.jan.primer.feature.login.choose.ChoosePasswordScreen
import com.mukul.jan.primer.feature.login.choose.ChooseUsernameScreen
import com.mukul.jan.primer.feature.login.signin.SignInScreen
import com.mukul.jan.primer.feature.login.signup.SignUpScreen


object LoginNav {
    private val root = Screen.Login

    sealed class Screen(val route: String) {
        object Login : Screen(route = "login")
    }

    sealed class NavScreen(val route: String) {
        fun createRoute(root: Screen) = "${root.route}/$route"

        object Primary : NavScreen(route = "primary")
        object ChooseUsername : NavScreen(route = "chooseUsername")
        object ChoosePassword : NavScreen(route = "choosePassword")
        object SignUp : NavScreen(route = "signUp")
        object SignIn : NavScreen(route = "signIn")
    }

    fun getRootRoute(): String {
        return root.route
    }

    fun addLoginNavAtTopLevel(navController: NavHostController, graph: NavGraphBuilder) {
        graph.apply {
            navigation(
                route = getRootRoute(),
                startDestination = NavScreen.Primary.createRoute(root),
            ) {
                composable(NavScreen.Primary.createRoute(root)) {
                    PrimaryLoginScreen(onSignIn = {
                        navController.navigate(NavScreen.SignIn.createRoute(root))
                    }, onSignUp = {
                        navController.navigate(NavScreen.ChooseUsername.createRoute(root))
                    })
                }
                composable(NavScreen.ChooseUsername.createRoute(root)) {
                    ChooseUsernameScreen(onNext = {
                        navController.navigate(NavScreen.ChoosePassword.createRoute(root))
                    }, onBack = {
                        navController.navigateUp()
                    })
                }
                composable(NavScreen.ChoosePassword.createRoute(root)) {
                    ChoosePasswordScreen(onNext = {
                        navController.navigate(NavScreen.SignUp.createRoute(root))
                    }, onBack = {
                        navController.navigateUp()
                    })
                }
                composable(NavScreen.SignUp.createRoute(root)) {
                    SignUpScreen(onFinish = {}, onBack = { navController.navigateUp() })
                }
                composable(NavScreen.SignIn.createRoute(root)) {
                    SignInScreen(onLoginSuccess = {}, onBack = { navController.navigateUp() })
                }
            }
        }
    }
}
