package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun ProposalStatusShimmerView() {
    Text(
        text = "PASSED",
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .placeholder(
                visible = true,
                color = Color.Gray,
                shape = RoundedCornerShape(100.dp),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = Color.White,
                )
            )
            .padding(12.dp)
    )
}