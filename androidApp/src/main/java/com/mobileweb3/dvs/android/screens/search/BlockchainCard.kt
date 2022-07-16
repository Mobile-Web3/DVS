package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.mobileweb3.dvs.android.screens.main.SPACER_HEIGHT
import com.mobileweb3.dvs.android.ui.composables.Avatar
import com.mobileweb3.dvs.android.ui.composables.getGradientBrush
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun BlockchainCard(
    blockchainNetworkViewItem: BlockchainNetworkViewItem.Data,
    modifier: Modifier,
    onBlockchainClicked: (BlockchainNetwork) -> Unit
) {
    var palette by remember { mutableStateOf<Palette?>(null) }

    Box(
        modifier = modifier
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
            .background(
                brush = getGradientBrush(palette),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onBlockchainClicked(blockchainNetworkViewItem.blockchainNetwork) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(SPACER_HEIGHT))

            Avatar(
                url = blockchainNetworkViewItem.blockchainNetwork.imageRef,
                widthHeightDp = 50.dp,
                onPaletteChanged = { palette = it }
            )

            Spacer(modifier = Modifier.height(SPACER_HEIGHT))

            BlockchainTitle(
                blockchainNetwork = blockchainNetworkViewItem.blockchainNetwork,
                colorPalette = palette
            )

            Spacer(modifier = Modifier.height(SPACER_HEIGHT))
        }
    }
}