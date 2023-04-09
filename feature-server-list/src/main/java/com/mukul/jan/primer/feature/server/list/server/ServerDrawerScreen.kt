package com.mukul.jan.primer.feature.server.list.server

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukul.jan.primer.base.ui.Dimens
import com.mukul.jan.primer.base.ui.R


@Composable
fun ServerDrawerScreen() {
    ServerDrawerScreenContent(scaffoldState = rememberScaffoldState())
}

@Composable
private fun ServerDrawerScreenContent(
    scaffoldState: ScaffoldState
) {
    Scaffold(
        scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            DrawerList()
        }
    }
}

@Composable
private fun DrawerList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(Dimens.TWO.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.TWO.dp)
    ) {
        item {
            DrawerListItem(
                modifier = Modifier, icon = R.drawable.baseline_chat_24
            )
        }
        item {
            DrawerListItem(
                modifier = Modifier, icon = R.drawable.baseline_add_circle_outline_24
            )
        }
    }
}

@Composable
private fun DrawerListItem(
    modifier: Modifier,
    @DrawableRes icon: Int,
) {
    IconButton(onClick = {}) {
        Box(
            modifier = modifier
                .size(Dimens.SEVEN.dp)
                .background(
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.03f),
                    shape = CircleShape
                )
        ) {
            Icon(
                modifier = modifier
                    .size(Dimens.THREE.dp)
                    .align(Alignment.Center),
                imageVector = ImageVector.vectorResource(icon),
                tint = MaterialTheme.colors.primary,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun DrawerListItem() {

}

@Preview
@Composable
private fun ServerDrawerScreenPreview() {
    ServerDrawerScreenContent(scaffoldState = rememberScaffoldState())
}