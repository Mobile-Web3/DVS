package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.screens.search.BlockchainCard
import com.mobileweb3.dvs.android.screens.search.BlockchainNetworkViewItem
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun NetworksGrid(
    blockchainNetworks: List<BlockchainNetwork>,
    modifier: Modifier = Modifier,
    onBlockchainNetworkClicked: (BlockchainNetwork) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier,
    ) {
        items(blockchainNetworks.toViewItems()) { item ->
            when (item) {
                BlockchainNetworkViewItem.Empty -> {

                }
                is BlockchainNetworkViewItem.Data -> {
                    BlockchainCard(
                        blockchainNetworkViewItem = item,
                        modifier = Modifier.padding(2.dp),
                        onBlockchainClicked = { network ->
                            onBlockchainNetworkClicked.invoke(network)
                        }
                    )
                }
            }
        }
    }
}

private fun List<BlockchainNetwork>.toViewItems(): List<BlockchainNetworkViewItem> {
    if (this.isEmpty()) {
        return listOf(BlockchainNetworkViewItem.Empty)
    }

    return map { BlockchainNetworkViewItem.Data(it) }
}