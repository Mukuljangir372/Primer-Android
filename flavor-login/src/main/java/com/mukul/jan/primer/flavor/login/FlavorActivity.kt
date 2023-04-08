package com.mukul.jan.primer.flavor.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mukul.jan.primer.base.ui.design.PrimerTheme
import com.mukul.jan.primer.feature.login.navigation.LoginNav
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlavorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            PrimerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = LoginNav.root.route
                    ) {
                        LoginNav.addLoginNavAtTopLevel(
                            navController = navController,
                            graph = this
                        )
                    }
                }
            }
        }
    }
}