package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.ui.composables.DefaultHeader
import com.mobileweb3.dvs.app.SearchNetworkAction
import com.mobileweb3.dvs.app.SearchNetworkStore
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun SearchValidatorContent(
    searchNetworkStore: SearchNetworkStore
) {
    val searchState = searchNetworkStore.observeState().collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp,
            )
    ) {
        DefaultHeader()

        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            value = text,
            label = { Text("Network title") },
            onValueChange = {
                text = it
            },
            maxLines = 1
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(16.dp),
        ) {
            items(searchState.value.networks.toViewItems()) { item ->
                when (item) {
                    BlockchainNetworkViewItem.Empty -> {

                    }
                    is BlockchainNetworkViewItem.Data -> {
                        BlockchainCard(
                            blockchainNetworkViewItem = item,
                            modifier = Modifier
                                .padding(2.dp)
                                .weight(1f),
                            onBlockchainClicked = { network ->
                                searchNetworkStore.dispatch(SearchNetworkAction.NetworkSelected(network))

                                //navigate or change state (like add selected network in state and recompose view)
                            }
                        )
                    }
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

sealed class BlockchainNetworkViewItem {

    object Empty : BlockchainNetworkViewItem()

    data class Data(val blockchainNetwork: BlockchainNetwork) : BlockchainNetworkViewItem()
}