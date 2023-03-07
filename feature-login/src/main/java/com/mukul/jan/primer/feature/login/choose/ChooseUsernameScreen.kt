package com.mukul.jan.primer.feature.login.choose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mu.jan.primer.common.ui.PrimaryRoundButton
import com.mu.jan.primer.common.ui.PrimaryTextField
import com.mukul.jan.primer.base.ui.Dimens
import com.mukul.jan.primer.base.ui.design.PrimerTheme
import com.mukul.jan.primer.feature.login.R

@Composable
fun ChooseUsernameScreen(
    onBack: () -> Unit,
    onNext: () -> Unit,
) {
    ChooseUsernameScreenContent(
        onBackPress = onBack,
        onNextClick = onNext,
        nameInputInitialValue = "",
        onNameInputValueChange = {},
    )
}

@Composable
private fun ChooseUsernameScreenContent(
    onBackPress: () -> Unit,
    onNextClick: () -> Unit,
    nameInputInitialValue: String,
    onNameInputValueChange: (String) -> Unit,
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = { Text(text = "") }, navigationIcon = {
            IconButton(onClick = onBackPress) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        }, backgroundColor = MaterialTheme.colors.background, elevation = Dimens.ZERO.dp
        )
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.choose_your_name),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(horizontal = Dimens.FIVE.dp),
                text = stringResource(id = R.string.choose_your_name_description),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dimens.FIVE.dp))
            PrimaryTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.THREE.dp),
                value = nameInputInitialValue,
                onValueChange = onNameInputValueChange,
                label = { Text(text = stringResource(id = R.string.name)) },
                placeholder = { Text(text = stringResource(id = R.string.name)) })
            Spacer(modifier = Modifier.height(Dimens.FIVE.dp))
            PrimaryRoundButton(onClick = onNextClick) {
                Row(
                    modifier = Modifier.padding(horizontal = Dimens.TWO.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.next),
                        fontWeight = FontWeight.Bold
                    )
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "next")
                }
            }
        }
    }
}

@Preview
@Composable
private fun ChooseUsernameScreenPreview() {
    PrimerTheme {
        ChooseUsernameScreenContent(
            onBackPress = {},
            nameInputInitialValue = "Mukul Jangir",
            onNameInputValueChange = {},
            onNextClick = {}
        )
    }
}