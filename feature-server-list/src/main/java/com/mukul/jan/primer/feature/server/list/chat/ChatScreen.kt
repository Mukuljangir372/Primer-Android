package com.mukul.jan.primer.feature.server.list.chat

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.mu.jan.primer.common.ui.compose.PrimaryTopAppBar
import com.mukul.jan.primer.base.ui.R
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@Composable
fun ChatScreen(onBack: () -> Unit) {
    ChatScreenContent(
        scaffoldState = rememberScaffoldState(), onBackPress = onBack
    )
}

@Composable
private fun ChatScreenContent(
    scaffoldState: ScaffoldState,
    onBackPress: () -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState, topBar = {
        PrimaryTopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = stringResource(id = R.string.chat),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold
                )
            },
            navigationIcon = ImageVector.vectorResource(id = R.drawable.baseline_dehaze_24),
            onNavigationIconClick = onBackPress
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}

@Preview
@Composable
private fun ChatScreenPreview() {
    PrimerTheme {
        ChatScreenContent(scaffoldState = rememberScaffoldState(), onBackPress = {})
    }
}