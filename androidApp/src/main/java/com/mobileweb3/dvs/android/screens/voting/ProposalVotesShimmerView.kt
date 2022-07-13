package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun ProposalVotesShimmerView() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp)),
    ) {
        Text(
            text = "",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(100.dp)
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
}