package com.mukul.jan.primer.base.ui.design

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp
import com.mukul.jan.primer.base.ui.Dimens

val Shapes = Shapes(
    small = RoundedCornerShape(Dimens.HALF.dp),
    medium = RoundedCornerShape(Dimens.HALF.dp),
    large = RoundedCornerShape(Dimens.ZERO.dp)
)