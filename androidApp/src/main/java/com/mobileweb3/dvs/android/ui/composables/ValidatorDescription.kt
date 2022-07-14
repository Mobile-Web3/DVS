package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.mobileweb3.dvs.app.ValidatorViewState

@Composable
fun ValidatorDescription(
    validatorViewState: ValidatorViewState,
    colorPalette: Palette?
) {
    if (validatorViewState.validatorModel == null) {
        return
    }

    Text(
        text = validatorViewState.validatorModel!!.getSmallDescription(),
        color = colorPalette?.mutedSwatch?.bodyTextColor?.let { Color(it) } ?: Color.White,
        maxLines = 6,
        textAlign = TextAlign.Start,
        style = typography.subtitle2,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    )
}