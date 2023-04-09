package com.mu.jan.primer.common.ui.compose

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.mukul.jan.primer.base.ui.Dimens

@Composable
fun PrimaryTopAppBar(
    modifier: Modifier,
    title: @Composable () -> Unit,
    navigationIcon: ImageVector? = null,
    onNavigationIconClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    val navigationIconLambda: @Composable () -> Unit = {
        navigationIcon?.let {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    navigationIcon, contentDescription = null
                )
            }
        }
    }

    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = Dimens.QUARTER.dp,
        title = title,
        navigationIcon = if (navigationIcon != null) {
            navigationIconLambda
        } else null,
        actions = actions
    )
}