package com.mukul.jan.primer.feature.server.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mu.jan.primer.common.ui.compose.CenterScreenState
import com.mu.jan.primer.common.ui.compose.PrimerPanelContainer
import com.mu.jan.primer.common.ui.compose.navigateTo
import com.mukul.jan.primer.base.ui.design.PrimerTheme
import com.mukul.jan.primer.feature.server.list.channel.ChannelListScreen
import com.mukul.jan.primer.feature.server.list.chat.ChatScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PrimaryServerScreen() {
    PrimaryServerScreenContent(
        scope = rememberCoroutineScope(), scaffoldState = rememberScaffoldState()
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun PrimaryServerScreenContent(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            PrimerPanelContainer(sidePanel = { _ ->

            }, leftPanel = { _ ->
                ChannelListScreen()
            }, centerPanel = { state ->
                ChatScreen(onBack = {
                    scope.launch {
                        state.navigateTo(CenterScreenState.RIGHT_ANCHORED)
                    }
                })
            })
        }
    }
}

@Preview
@Composable
private fun PrimaryServerScreenPreview() {
    PrimerTheme {
        PrimaryServerScreenContent(
            scope = rememberCoroutineScope(), scaffoldState = rememberScaffoldState()
        )
    }
}