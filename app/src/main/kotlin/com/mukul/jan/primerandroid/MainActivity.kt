package com.mukul.jan.primerandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.mukul.jan.primerandroid.flavor.FlavorContainer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FlavorContainer().startFlavorEntry(this)
        finish()
    }
}