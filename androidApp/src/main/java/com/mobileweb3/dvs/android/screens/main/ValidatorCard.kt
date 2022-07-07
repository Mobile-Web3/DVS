package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.mobileweb3.dvs.app.ValidatorViewState
import com.mobileweb3.dvs.core.entity.ValidatorModel

@Composable
fun ValidatorCard(
    validatorViewState: ValidatorViewState,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .height(200.dp)
    ) {
        Text(
            text = validatorViewState.validatorModel?.title ?: "default text",
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .placeholder(
                    visible = validatorViewState.isLoading,
                    color = Color.Gray,
                    // optional, defaults to RectangleShape
                    shape = RoundedCornerShape(4.dp),
                    highlight = PlaceholderHighlight.shimmer(
                        highlightColor = Color.White,
                    )
                )
        )
    }
}