package com.tunahankaryagdi.minimapgame.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textResId: Int,
    height: Dp = (LocalConfiguration.current.screenHeightDp * (0.08)).dp
) {

    Button(
        modifier = modifier
            .height(height),
        onClick = onClick,
    ) {
        Text(text = stringResource(id = textResId))
    }
}