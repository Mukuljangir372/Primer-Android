package com.mukul.jan.primer.base.ui.design

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.mukul.jan.primer.base.ui.R

private val NunitoFontFamily = FontFamily(
    Font(R.font.nunito_regular, FontWeight.Normal),
    Font(R.font.nunito_black, FontWeight.Black),
    Font(R.font.nunito_bold, FontWeight.Bold),
    Font(R.font.nunito_light, FontWeight.Light),
    Font(R.font.nunito_medium, FontWeight.Medium),
    Font(R.font.nunito_extrabold, FontWeight.ExtraBold),
)
val PrimaryTypography = Typography(
    defaultFontFamily = NunitoFontFamily
)