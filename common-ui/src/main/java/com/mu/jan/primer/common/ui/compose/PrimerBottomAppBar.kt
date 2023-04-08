package com.mu.jan.primer.common.ui.compose

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.mukul.jan.primer.base.ui.R
import com.mukul.jan.primer.base.ui.design.PrimerTheme

data class BottomNavItem(
    val id: Int, val label: String, val icon: ImageVector?, @DrawableRes val drawable: Int?
)

@Composable
fun PrimaryBottomAppBar(
    modifier: Modifier,
    items: List<BottomNavItem>,
    onItemClick: (item: BottomNavItem) -> Unit,
    selectedItemId: Int,
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary
    ) {
        items.forEach { item ->
            BottomNavigationItem(selected = item.id == selectedItemId,
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
                onClick = {
                    onItemClick.invoke(item)
                },
                icon = {
                    Icon(
                        imageVector = item.icon ?: ImageVector.vectorResource(id = item.drawable!!),
                        contentDescription = null,
                    )
                })
        }
    }
}

@Preview
@Composable
private fun PrimaryBottomAppBarPreview() {
    PrimerTheme {
        val items = listOf(
            BottomNavItem(
                id = 1, label = "chat", icon = null, drawable = R.drawable.baseline_chat_24
            )
        )
        PrimaryBottomAppBar(
            modifier = Modifier, items = items, onItemClick = {}, selectedItemId = 0
        )
    }
}