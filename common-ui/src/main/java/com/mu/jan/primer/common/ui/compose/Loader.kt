package com.mu.jan.primer.common.ui.compose

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun PrimerCircularLoader(modifier: Modifier) {
    val strokeWidth = 5.dp
    val color = MaterialTheme.colors.primary
    CircularProgressIndicator(
        modifier = modifier.drawBehind {
            drawCircle(
                color.copy(alpha = 0.2f),
                radius = size.width / 2 - strokeWidth.toPx() / 2,
                style = Stroke(strokeWidth.toPx())
            )
        },
        color = color,
        strokeWidth = strokeWidth
    )
}