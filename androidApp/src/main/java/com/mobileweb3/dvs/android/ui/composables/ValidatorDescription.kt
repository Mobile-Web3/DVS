package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.app.ValidatorViewState

@Composable
fun ValidatorDescription(
    validatorViewState: ValidatorViewState
) {
    if (validatorViewState.validatorModel == null) {
        return
    }

    val smallDescription = validatorViewState.validatorModel!!.getSmallDescription()
    if (smallDescription.isNotEmpty()) {
        Text(
            text = validatorViewState.validatorModel!!.getSmallDescription(),
            textAlign = TextAlign.Start,
            style = typography.subtitle2,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(8.dp)
        )
    }
}