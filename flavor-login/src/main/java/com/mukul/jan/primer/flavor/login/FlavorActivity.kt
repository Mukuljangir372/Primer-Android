package com.mukul.jan.primer.flavor.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mukul.jan.primer.feature.login.PrimaryLoginScreen

class FlavorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimaryLoginScreen()
        }
    }
}