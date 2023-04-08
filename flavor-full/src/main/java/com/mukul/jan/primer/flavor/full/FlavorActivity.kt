package com.mukul.jan.primer.flavor.full

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mukul.jan.primer.base.ui.design.PrimerTheme
import com.mukul.jan.primer.feature.dashboard.DashboardScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlavorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimerTheme {
                DashboardScreen()
            }
        }
    }
}