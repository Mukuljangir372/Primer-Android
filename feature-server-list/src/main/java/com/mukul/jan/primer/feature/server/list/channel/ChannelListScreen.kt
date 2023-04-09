package com.mukul.jan.primer.feature.server.list.channel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mu.jan.primer.common.ui.compose.PrimerTopAppBar
import com.mukul.jan.primer.base.ui.Dimens
import com.mukul.jan.primer.base.ui.R
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@Composable
fun ChannelListScreen() {
    ChannelListScreenContent(scaffoldState = rememberScaffoldState(), onInfoClick = {})
}

@Composable
private fun ChannelListScreenContent(
    scaffoldState: ScaffoldState,
    onInfoClick: () -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState, topBar = {
        PrimerTopAppBar(modifier = Modifier.fillMaxWidth(),
            title = {
                Text(
                    text = stringResource(id = R.string.server),
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.SemiBold
                )
            },
            actions = {
                IconButton(onClick = onInfoClick) {
                    Icon(
                        ImageVector.vectorResource(id = R.drawable.baseline_more_vert_24),
                        contentDescription = null
                    )
                }
            })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ChannelGroupList(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun ChannelGroupList(
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(Dimens.ONE.dp),
        verticalArrangement = Arrangement.spacedBy(Dimens.ONE.dp),
        state = rememberLazyListState(),
    ) {
        item {
            ChannelGroupListItem()
        }
        item {
            ChannelGroupListItem()
        }
    }
}

@Composable
private fun ChannelGroupListItem() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(Dimens.TWO.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = null
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "Information",
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.SemiBold
            )
            Icon(
                modifier = Modifier.size(Dimens.TWO.dp + Dimens.HALF.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_24),
                contentDescription = null
            )
        }

        // TODO handle in loop
        ChannelListItem(modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ONE.dp))
        ChannelListItem(modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ONE.dp))
    }
}

@Composable
private fun ChannelListItem(modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(Dimens.TWO.dp + Dimens.HALF.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_grid_3x3_24),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground.copy(alpha = 0.5f)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "mobile-apps",
            style = MaterialTheme.typography.subtitle1,
        )
    }
}


@Preview
@Composable
private fun ChannelListScreenPreview() {
    PrimerTheme {
        ChannelListScreenContent(scaffoldState = rememberScaffoldState(), onInfoClick = {})
    }
}