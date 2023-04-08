package com.mukul.jan.primer.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mu.jan.primer.common.ui.compose.PrimaryBottomAppBar
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@Composable
fun DashboardScreen(
    content: @Composable () -> Unit, onSelectBottomNavItem: (id: Int) -> Unit
) {
    val selectedBottomItemId = remember {
        mutableStateOf(DashboardScreenUtils.bottomNavItems.first().id)
    }
    LaunchedEffect(selectedBottomItemId) {
        onSelectBottomNavItem.invoke(selectedBottomItemId.value)
    }
    DashboardScreenContent(
        modifier = Modifier,
        scaffoldState = rememberScaffoldState(),
        selectedBottomItem = selectedBottomItemId.value,
        onSelectBottomNavItem = {
            selectedBottomItemId.value = it
        },
        content = content
    )
}

@Composable
private fun DashboardScreenContent(
    modifier: Modifier,
    scaffoldState: ScaffoldState,
    selectedBottomItem: Int,
    onSelectBottomNavItem: (Int) -> Unit,
    content: @Composable () -> Unit,
) {
    Scaffold(modifier = modifier, scaffoldState = scaffoldState, bottomBar = {
        PrimaryBottomAppBar(
            modifier = Modifier,
            items = DashboardScreenUtils.bottomNavItems,
            onItemClick = {
                onSelectBottomNavItem.invoke(it.id)
            },
            selectedItemId = selectedBottomItem
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            content.invoke()
        }
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    PrimerTheme {
        DashboardScreenContent(modifier = Modifier,
            scaffoldState = rememberScaffoldState(),
            selectedBottomItem = 2,
            onSelectBottomNavItem = {},
            content = {})
    }
}