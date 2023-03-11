package com.mu.jan.primer.common.ui.compose

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukul.jan.primer.base.ui.Dimens
import com.mukul.jan.primer.base.ui.design.PrimerTheme

@Composable
fun PrimaryTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    TextField(
        modifier = modifier,
        value = value,
        label = label,
        placeholder = placeholder,
        onValueChange = onValueChange,
        enabled = enabled,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledLabelColor = MaterialTheme.colors.primary,
            disabledTextColor = LocalContentColor.current
        ),
        shape = RoundedCornerShape(Dimens.HALF.dp),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Preview
@Composable
private fun PrimaryTextFieldPreview() {
    PrimerTheme(darkTheme = false) {
        PrimaryTextField(
            modifier = Modifier,
            value = "Value",
            onValueChange = {},
            enabled = true,
            label = {
                Text(text = "Label")
            }
        )
    }
}