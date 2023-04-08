package com.mukul.jan.primer.feature.server.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PrimaryServerScreen() {
    PrimaryServerScreenContent(
        scaffoldState = rememberScaffoldState(), pagerState = rememberPagerState()
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun PrimaryServerScreenContent(
    scaffoldState: ScaffoldState,
    pagerState: PagerState,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize(), state = pagerState, count = 3
            ) { page ->
                Text(text = "page = $page")
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
private fun PrimaryServerScreenPreview() {
    PrimerTheme {
        PrimaryServerScreenContent(
            scaffoldState = rememberScaffoldState(), pagerState = rememberPagerState()
        )
    }
}