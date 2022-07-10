package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun AvatarShimmer(
    widthHeightDp: Dp,
) {
    Text(
        text = "default text",
        modifier = Modifier
            .width(widthHeightDp)
            .height(widthHeightDp)
            .placeholder(
                visible = true,
                color = Color.Gray,
                shape = RoundedCornerShape(100.dp),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = Color.White,
                )
            )
    )
}