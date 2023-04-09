package com.mukul.jan.primer.feature.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mu.jan.primer.common.ui.compose.PrimaryRoundButton
import com.mukul.jan.primer.base.ui.Dimens
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@Composable
fun PrimaryLoginScreen(
    onSignUp: () -> Unit,
    onSignIn: () -> Unit,
) {
    PrimaryLoginScreenContent(
        onSignUpClick = onSignUp,
        onLoginClick = onSignIn,
    )
}

@Composable
private fun PrimaryLoginScreenContent(
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.TWO.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.size(Dimens.SEVEN.dp),
                painter = painterResource(id = com.mukul.jan.primer.base.ui.R.drawable.monkey),
                contentDescription = "Primer"
            )
            Spacer(modifier = Modifier.height(Dimens.ONE.dp))
            Text(
                text = stringResource(id = com.mukul.jan.primer.base.ui.R.string.primer),
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                modifier = Modifier.padding(horizontal = Dimens.FIVE.dp),
                text = stringResource(id = R.string.chat_description),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dimens.FIVE.dp))
            PrimaryRoundButton(onClick = onSignUpClick) {
                Row(
                    modifier = Modifier.padding(horizontal = Dimens.TWO.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontWeight = FontWeight.Bold
                    )
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "next")
                }
            }
            Spacer(modifier = Modifier.height(Dimens.ONE.dp))
            Text(
                modifier = Modifier.clickable {
                    onLoginClick.invoke()
                },
                text = stringResource(id = R.string.log_in),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun PrimaryLoginScreenPreview() {
    PrimerTheme(darkTheme = false) {
        PrimaryLoginScreenContent(
            onSignUpClick = {},
            onLoginClick = {},
        )
    }
}