package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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
import com.mobileweb3.dvs.android.ui.composables.Avatar
import com.mobileweb3.dvs.android.ui.composables.getGradientBrush
import com.mobileweb3.dvs.app.SearchNetworkAction
import com.mobileweb3.dvs.app.SearchNetworkStore
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun SelectedNetworkView(
    selectedNetwork: BlockchainNetwork,
    searchNetworkStore: SearchNetworkStore
) {
    var palette by remember { mutableStateOf<Palette?>(null) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp
            )
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
            .background(
                brush = getGradientBrush(palette),
                shape = RoundedCornerShape(10.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Avatar(
            url = selectedNetwork.imageRef,
            widthHeightDp = 50.dp,
            onPaletteChanged = { palette = it },
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        BlockchainTitle(
            blockchainNetwork = selectedNetwork,
            colorPalette = palette,
            textStyle = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = { searchNetworkStore.dispatch(SearchNetworkAction.NetworkSelectCanceled) }
        ) {
            Icon(
                imageVector = Icons.Filled.Clear,
                contentDescription = "Clear",
                tint = palette?.mutedSwatch?.bodyTextColor?.let { Color(it) } ?: Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}