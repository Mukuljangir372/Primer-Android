package com.mukul.jan.primer.feature.login.choose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mu.jan.primer.common.ui.ErrorMessage
import com.mu.jan.primer.common.ui.compose.PrimaryRoundButton
import com.mu.jan.primer.common.ui.compose.PrimaryTextField
import com.mukul.jan.primer.base.ui.Dimens
import com.mukul.jan.primer.base.ui.design.PrimerTheme
import com.mukul.jan.primer.feature.login.R
import kotlinx.coroutines.flow.filterIsInstance

@Composable
fun ChoosePasswordScreen(
    onBack: () -> Unit,
    onNext: () -> Unit,
) {
    val viewModel: ChoosePasswordViewModel = hiltViewModel()
    val uiState by viewModel.uiState.filterIsInstance<ChoosePasswordViewModel.UiState.ChoosePassword>()
        .collectAsState(null)

    uiState?.let {
        LaunchedEffect(it.passwordValidated) {
            if (it.passwordValidated) {
                onNext.invoke()
                viewModel.onPasswordValidationRevert()
            }
        }
        ChoosePasswordScreenContent(
            onBackPress = onBack,
            onNextClick = viewModel::validate,
            passwordInputInitialValue = it.password,
            confirmPasswordInputInitialValue = it.confirmPassword,
            onPasswordInputValueChange = viewModel::onPasswordChanged,
            onConfirmPasswordInputValueChange = viewModel::onConfirmPasswordChange,
            errorMessages = it.errorMessages,
            onErrorMessageShown = viewModel::onErrorMessageShown,
            scaffoldState = rememberScaffoldState(),
        )
    }
}

@Composable
private fun ChoosePasswordScreenContent(
    onBackPress: () -> Unit,
    onNextClick: () -> Unit,
    passwordInputInitialValue: String,
    confirmPasswordInputInitialValue: String,
    onPasswordInputValueChange: (String) -> Unit,
    onConfirmPasswordInputValueChange: (String) -> Unit,
    errorMessages: List<ErrorMessage>,
    onErrorMessageShown: (Long) -> Unit,
    scaffoldState: ScaffoldState,
) {
    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize(), topBar = {
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
                text = stringResource(id = R.string.choose_your_password),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(horizontal = Dimens.FIVE.dp),
                text = stringResource(id = R.string.choose_your_password_description),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dimens.FIVE.dp))
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
            Spacer(modifier = Modifier.height(Dimens.HALF.dp))
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.THREE.dp),
                value = confirmPasswordInputInitialValue,
                onValueChange = onConfirmPasswordInputValueChange,
                label = { Text(text = stringResource(id = R.string.confirm_password)) },
                placeholder = { Text(text = stringResource(id = R.string.confirm_password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(Dimens.FIVE.dp))
            PrimaryRoundButton(onClick = onNextClick) {
                Row(
                    modifier = Modifier.padding(horizontal = Dimens.TWO.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.next), fontWeight = FontWeight.Bold
                    )
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "next")
                }
            }
        }
    }

    if (errorMessages.isNotEmpty()) {
        val errorMessage = errorMessages.first()
        val errorMessageText = when (errorMessage) {
            is ErrorMessage.StringIdType -> stringResource(id = errorMessage.resId)
            is ErrorMessage.StringType -> errorMessage.message
        }
        LaunchedEffect(errorMessageText) {
            scaffoldState.snackbarHostState.showSnackbar(
                message = errorMessageText,
            )
            onErrorMessageShown(errorMessage.id)
        }
    }
}

@Preview
@Composable
private fun ChoosePasswordScreenPreview() {
    PrimerTheme {
        ChoosePasswordScreenContent(
            onBackPress = {},
            onNextClick = {},
            passwordInputInitialValue = "",
            confirmPasswordInputInitialValue = "",
            onPasswordInputValueChange = {},
            onConfirmPasswordInputValueChange = {},
            errorMessages = emptyList(),
            onErrorMessageShown = {},
            scaffoldState = rememberScaffoldState()
        )
    }
}