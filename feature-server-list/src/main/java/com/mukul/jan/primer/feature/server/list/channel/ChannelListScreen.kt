package com.mukul.jan.primer.feature.server.list.channel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mu.jan.primer.common.ui.compose.PrimerTopAppBar
import com.mukul.jan.primer.base.ui.R
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@Composable
fun ChannelListScreen() {
    ChannelListScreenContent(
        scaffoldState = rememberScaffoldState()
    )
}

@Composable
private fun ChannelListScreenContent(
    scaffoldState: ScaffoldState
) {
    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState, topBar = {
        PrimerTopAppBar(modifier = Modifier.fillMaxWidth(), title = {
            Text(
                text = stringResource(id = R.string.server),
                style = MaterialTheme.typography.subtitle1
            )
        }, navigationIcon = Icons.Default.List, onNavigationIconClick = {

        })
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

        }
    }
}

@Preview
@Composable
private fun ChannelListScreenPreview() {
    PrimerTheme {
        ChannelListScreenContent(
            scaffoldState = rememberScaffoldState()
        )
    }
}