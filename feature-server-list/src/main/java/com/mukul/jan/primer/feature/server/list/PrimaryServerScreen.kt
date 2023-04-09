package com.mukul.jan.primer.feature.server.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mu.jan.primer.common.ui.compose.PrimerPanelContainer
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@Composable
fun PrimaryServerScreen() {
    PrimaryServerScreenContent(
        scaffoldState = rememberScaffoldState()
    )
}

@Composable
private fun PrimaryServerScreenContent(
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
            PrimerPanelContainer(
                sidePanel = {

                },
                leftPanel = {

                },
                centerPanel = {

                }
            )
        }
    }
}

@Preview
@Composable
private fun PrimaryServerScreenPreview() {
    PrimerTheme {
        PrimaryServerScreenContent(
            scaffoldState = rememberScaffoldState()
        )
    }
}