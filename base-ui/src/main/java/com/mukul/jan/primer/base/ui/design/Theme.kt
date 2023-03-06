package com.mukul.jan.primer.base.ui.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Blue200,
    primaryVariant = Blue500,
    secondary = Blue800,
    background = White
)

private val DarkColorPalette = darkColors(
    primary = Blue200,
    primaryVariant = Blue500,
    secondary = Blue800,
    background = Black
)

@Composable
fun PrimerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette
    else LightColorPalette

    MaterialTheme(
        colors = colors,
        content = content,
        shapes = Shapes,
        typography = PrimaryTypography
    )
}