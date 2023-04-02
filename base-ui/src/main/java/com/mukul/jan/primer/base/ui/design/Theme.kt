package com.mukul.jan.primer.base.ui.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightColorPalette = lightColors(
    primary = Blue200,
    primaryVariant = Blue500,
    secondary = Blue800,
    background = White,
    onSurface = Blue100
)

private val DarkColorPalette = darkColors(
    primary = Blue200,
    primaryVariant = Blue500,
    secondary = Blue800,
    background = Black,
    onSurface = Blue100
)

@Composable
fun PrimerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette
    else LightColorPalette

    val uiController = rememberSystemUiController()
    val statusBarColor = if (darkTheme) Color.Black else Color.White
    uiController.setStatusBarColor(statusBarColor)

    MaterialTheme(
        colors = colors,
        content = content,
        shapes = Shapes,
        typography = PrimaryTypography
    )
}