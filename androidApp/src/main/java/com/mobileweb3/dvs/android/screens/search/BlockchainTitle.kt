package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun BlockchainTitle(
    blockchainNetwork: BlockchainNetwork,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.h6
) {
    Text(
        text = blockchainNetwork.title,
        color = Color.White,
        maxLines = 1,
        textAlign = TextAlign.Center,
        style = textStyle,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .background(
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp)
    )
}