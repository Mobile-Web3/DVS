package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun BlockchainTitle(
    blockchainNetwork: BlockchainNetwork,
    colorPalette: Palette?
) {
    Text(
        text = blockchainNetwork.title,
        color = colorPalette?.mutedSwatch?.bodyTextColor?.let { Color(it) } ?: Color.White,
        maxLines = 1,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
    )
}