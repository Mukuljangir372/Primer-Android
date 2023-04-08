package com.mu.jan.primer.common.ui.compose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukul.jan.primer.base.ui.Dimens

@Composable
fun PrimaryRoundButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        shape = RoundedCornerShape(Dimens.FIVE.dp),
        onClick = onClick,
    ) {
        content.invoke()
    }
}

@Preview
@Composable
private fun PrimaryRoundButtonPreview() {
    PrimaryRoundButton(
        onClick = {},
        content = {}
    )
}