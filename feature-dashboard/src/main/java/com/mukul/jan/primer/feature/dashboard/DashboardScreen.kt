package com.mukul.jan.primer.feature.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mu.jan.primer.common.ui.compose.BottomNavItem
import com.mu.jan.primer.common.ui.compose.PrimaryBottomAppBar
import com.mukul.jan.primer.base.ui.R
import com.mukul.jan.primer.base.ui.design.PrimerTheme

private val bottomAppBarItems: List<BottomNavItem> by lazy {
    listOf(
        BottomNavItem(
            id = 1, label = "chats", icon = null, drawable = R.drawable.baseline_chat_24
        ),
        BottomNavItem(
            id = 2, label = "friends", icon = null, drawable = R.drawable.baseline_groups_24
        ),
        BottomNavItem(
            id = 3, label = "files", icon = null, drawable = R.drawable.baseline_cloud_24
        ),
        BottomNavItem(
            id = 4, label = "alerts", icon = null, drawable = R.drawable.baseline_star_24
        ),
        BottomNavItem(
            id = 5, label = "profile", icon = null, drawable = R.drawable.baseline_person_24
        ),
    )
}

@Composable
fun DashboardScreen() {
    val selectedBottomItemId = remember {
        mutableStateOf(bottomAppBarItems.first().id)
    }
    DashboardScreenContent(modifier = Modifier,
        scaffoldState = rememberScaffoldState(),
        selectedBottomItem = selectedBottomItemId.value,
        onBottomItemSelect = {
            selectedBottomItemId.value = it
        })
}

@Composable
private fun DashboardScreenContent(
    modifier: Modifier,
    scaffoldState: ScaffoldState,
    selectedBottomItem: Int,
    onBottomItemSelect: (Int) -> Unit,
) {
    Scaffold(modifier = modifier, scaffoldState = scaffoldState, bottomBar = {
        PrimaryBottomAppBar(modifier = Modifier, items = bottomAppBarItems, onItemClick = {
            onBottomItemSelect.invoke(it.id)
        }, selectedItemId = selectedBottomItem)
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

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
            onBottomItemSelect = {})
    }
}