package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.mobileweb3.dvs.app.ValidatorViewState

@Composable
fun ValidatorTitle(
    validatorViewState: ValidatorViewState,
    modifier: Modifier
) {
    Text(
        text = validatorViewState.validatorModel?.title ?: "default text",
        color =  Color.White,
        maxLines = 2,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .placeholder(
                visible = validatorViewState.isLoading,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = Color.White,
                )
            )
            .background(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp)
    )
}