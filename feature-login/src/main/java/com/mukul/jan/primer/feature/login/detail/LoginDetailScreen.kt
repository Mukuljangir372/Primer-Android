package com.mukul.jan.primer.feature.login.detail

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
fun LoginDetailScreen() {
    LoginDetailScreenContent(
        onBackPress = {},
        onFinishClick = {},
        nameInputValue = "",
        privateKeyInputValue = "",
        publicKeyInputValue = ""
    )
}

@Composable
private fun LoginDetailScreenContent(
    onBackPress: () -> Unit,
    onFinishClick: () -> Unit,
    nameInputValue: String,
    privateKeyInputValue: String,
    publicKeyInputValue: String,
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
                text = stringResource(id = R.string.save_your_details),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(horizontal = Dimens.FIVE.dp),
                text = stringResource(id = R.string.save_your_details_description),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dimens.FOUR.dp))
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.THREE.dp),
                value = nameInputValue,
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.name)) },
                placeholder = { Text(text = stringResource(id = R.string.name)) },
                enabled = false
            )
            Spacer(modifier = Modifier.height(Dimens.HALF.dp))
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.THREE.dp),
                value = privateKeyInputValue,
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.private_key)) },
                placeholder = { Text(text = stringResource(id = R.string.private_key)) },
                enabled = false,
                trailingIcon = {
                    Text(
                        modifier = Modifier.padding(horizontal = Dimens.ONE.dp),
                        fontWeight = FontWeight.Bold,
                        text = stringResource(id = R.string.copy)
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimens.HALF.dp))
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.THREE.dp),
                value = publicKeyInputValue,
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.public_key)) },
                placeholder = { Text(text = stringResource(id = R.string.public_key)) },
                enabled = false,
                trailingIcon = {
                    Text(
                        modifier = Modifier.padding(horizontal = Dimens.ONE.dp),
                        fontWeight = FontWeight.Bold,
                        text = stringResource(id = R.string.copy)
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimens.FOUR.dp))
            PrimaryRoundButton(onClick = onFinishClick) {
                Row(
                    modifier = Modifier.padding(horizontal = Dimens.TWO.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.finish),
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
private fun LoginDetailScreenPreview() {
    PrimerTheme {
        LoginDetailScreenContent(
            onBackPress = {},
            onFinishClick = {},
            nameInputValue = "",
            privateKeyInputValue = "",
            publicKeyInputValue = ""
        )
    }
}