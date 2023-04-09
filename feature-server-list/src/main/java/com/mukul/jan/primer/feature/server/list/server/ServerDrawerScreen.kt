package com.mukul.jan.primer.feature.server.list.server

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ServerDrawerScreen() {
    ServerDrawerScreenContent(scaffoldState = rememberScaffoldState())
}

@Composable
private fun ServerDrawerScreenContent(
    scaffoldState: ScaffoldState
) {
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

        }
    }
}

@Preview
@Composable
private fun ServerDrawerScreenPreview() {
    ServerDrawerScreenContent(scaffoldState = rememberScaffoldState())
}