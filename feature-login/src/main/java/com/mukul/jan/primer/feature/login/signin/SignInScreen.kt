package com.mukul.jan.primer.feature.login.signin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mu.jan.primer.common.ui.compose.PrimaryRoundButton
import com.mu.jan.primer.common.ui.compose.PrimaryTextField
import com.mukul.jan.primer.base.ui.Dimens
import com.mukul.jan.primer.base.ui.design.PrimerTheme
import com.mukul.jan.primer.feature.login.R

@Composable
fun SignInScreen(
    onBack: () -> Unit,
    onLogin: () -> Unit,
) {
    SignInScreenContent(
        onBackPress = onBack,
        onLoginClick = onLogin,
        privateKeyInputInitialValue = " ",
        onPrivateKeyInputValueChange = {},
        passwordInputInitialValue = " ",
        onPasswordInputValueChange = {}
    )
}

@Composable
private fun SignInScreenContent(
    onBackPress: () -> Unit,
    onLoginClick: () -> Unit,
    privateKeyInputInitialValue: String,
    onPrivateKeyInputValueChange: (String) -> Unit,
    passwordInputInitialValue: String,
    onPasswordInputValueChange: (String) -> Unit,
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
                text = stringResource(id = R.string.welcome_back),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(horizontal = Dimens.FOUR.dp),
                text = stringResource(id = R.string.enter_your_private_key_and_password),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(horizontal = Dimens.FIVE.dp),
                text = stringResource(id = R.string.lets_talk_with_friends),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dimens.FOUR.dp))
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.THREE.dp),
                value = privateKeyInputInitialValue,
                onValueChange = onPrivateKeyInputValueChange,
                label = { Text(text = stringResource(id = R.string.private_key)) },
                placeholder = { Text(text = stringResource(id = R.string.private_key)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(Dimens.HALF.dp))
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.THREE.dp),
                value = passwordInputInitialValue,
                onValueChange = onPasswordInputValueChange,
                label = { Text(text = stringResource(id = R.string.password)) },
                placeholder = { Text(text = stringResource(id = R.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(Dimens.FOUR.dp))
            PrimaryRoundButton(onClick = onLoginClick) {
                Row(
                    modifier = Modifier.padding(horizontal = Dimens.TWO.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.log_in), fontWeight = FontWeight.Bold
                    )
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "next")
                }
            }
        }
    }
}

@Preview
@Composable
private fun SignInScreenPreview() {
    PrimerTheme {
        SignInScreenContent(
            onBackPress = {},
            onLoginClick = {},
            privateKeyInputInitialValue = "",
            onPrivateKeyInputValueChange = {},
            passwordInputInitialValue = "",
            onPasswordInputValueChange = {}
        )
    }
}