package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.layout.padding
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
    colorPalette: Palette?,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.h6
) {
    Text(
        text = blockchainNetwork.title,
        color = colorPalette?.mutedSwatch?.bodyTextColor?.let { Color(it) } ?: Color.White,
        maxLines = 1,
        textAlign = TextAlign.Center,
        style = textStyle,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .padding(start = 4.dp, end = 4.dp)
    )
}