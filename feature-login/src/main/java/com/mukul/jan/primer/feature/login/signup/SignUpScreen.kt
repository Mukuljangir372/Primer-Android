package com.mukul.jan.primer.feature.login.signup

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
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
fun SignUpScreen(
    onBack: () -> Unit,
    onFinish: () -> Unit,
) {
    val viewModel: SignUpViewModel = hiltViewModel()
    val uiState by viewModel.uiState.filterIsInstance<SignUpViewModel.UiState.Details>()
        .collectAsState(null)

    val clipboard = LocalClipboardManager.current

    uiState?.let {
        LaunchedEffect(it.signUp) {
            if (it.signUp) {
                onFinish.invoke()
                viewModel.onSignUpRevert()
            }
        }
        SignUpScreenContent(onBackPress = onBack,
            onFinishClick = viewModel::validateAndSignUp,
            nameInputValue = it.username,
            privateKeyInputValue = it.privateKey,
            publicKeyInputValue = it.publicKey,
            errorMessages = it.errorMessages,
            onErrorMessageShown = viewModel::onErrorMessageShown,
            scaffoldState = rememberScaffoldState(),
            context = LocalContext.current,
            onCopyClick = {
                clipboard.setText(buildAnnotatedString { append(it) })
                viewModel.showErrorMessage(R.string.copied)
            })
    }
}

@Composable
private fun SignUpScreenContent(
    onBackPress: () -> Unit,
    onFinishClick: () -> Unit,
    onCopyClick: (String) -> Unit,
    nameInputValue: String,
    privateKeyInputValue: String,
    publicKeyInputValue: String,
    errorMessages: List<ErrorMessage>,
    onErrorMessageShown: (Long) -> Unit,
    scaffoldState: ScaffoldState,
    context: Context,
) {
    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState, topBar = {
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
            PrimaryTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.THREE.dp),
                value = privateKeyInputValue,
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.private_key)) },
                placeholder = { Text(text = stringResource(id = R.string.private_key)) },
                enabled = false,
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            onCopyClick.invoke(privateKeyInputValue)
                        },
                        painter = painterResource(id = com.mukul.jan.primer.base.ui.R.drawable.baseline_content_copy_24),
                        contentDescription = null
                    )
                })
            Spacer(modifier = Modifier.height(Dimens.HALF.dp))
            PrimaryTextField(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.THREE.dp),
                value = publicKeyInputValue,
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.public_key)) },
                placeholder = { Text(text = stringResource(id = R.string.public_key)) },
                enabled = false,
                trailingIcon = {
                    Icon(
                        modifier = Modifier.clickable {
                            onCopyClick.invoke(publicKeyInputValue)
                        },
                        painter = painterResource(id = com.mukul.jan.primer.base.ui.R.drawable.baseline_content_copy_24),
                        contentDescription = null
                    )
                })
            Spacer(modifier = Modifier.height(Dimens.FOUR.dp))
            PrimaryRoundButton(onClick = onFinishClick) {
                Row(
                    modifier = Modifier.padding(horizontal = Dimens.TWO.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.finish), fontWeight = FontWeight.Bold
                    )
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "next")
                }
            }
        }
    }

    LaunchedEffect(errorMessages) {
        if (errorMessages.isNotEmpty()) {
            val errorMessage = errorMessages.first()
            val errorMessageText = when (errorMessage) {
                is ErrorMessage.StringIdType -> context.getString(errorMessage.resId)
                is ErrorMessage.StringType -> errorMessage.message
            }
            scaffoldState.snackbarHostState.showSnackbar(
                message = errorMessageText,
            )
            onErrorMessageShown(errorMessage.id)
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    PrimerTheme {
        SignUpScreenContent(onBackPress = {},
            onFinishClick = {},
            nameInputValue = "",
            privateKeyInputValue = "",
            publicKeyInputValue = "",
            errorMessages = emptyList(),
            onErrorMessageShown = {},
            scaffoldState = rememberScaffoldState(),
            context = LocalContext.current,
            onCopyClick = {})
    }
}