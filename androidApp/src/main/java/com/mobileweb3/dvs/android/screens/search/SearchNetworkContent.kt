package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.app.SearchNetworkAction
import com.mobileweb3.dvs.app.SearchNetworkState
import com.mobileweb3.dvs.app.SearchNetworkStore
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun SearchNetworkContent(
    searchState: SearchNetworkState,
    searchNetworkStore: SearchNetworkStore
) {
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
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(
                    onClick = {
                        text = ""
                        searchNetworkStore.dispatch(SearchNetworkAction.SearchStringChanged(text))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Clear",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        },
        onValueChange = {
            text = it
            searchNetworkStore.dispatch(SearchNetworkAction.SearchStringChanged(text))
        },
        maxLines = 1
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(16.dp),
    ) {
        items(searchState.networks.toViewItems()) { item ->
            when (item) {
                BlockchainNetworkViewItem.Empty -> {

                }
                is BlockchainNetworkViewItem.Data -> {
                    BlockchainCard(
                        blockchainNetworkViewItem = item,
                        modifier = Modifier.padding(2.dp),
                        onBlockchainClicked = { network ->
                            searchNetworkStore.dispatch(SearchNetworkAction.NetworkSelected(network))
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

sealed class BlockchainNetworkViewItem {

    object Empty : BlockchainNetworkViewItem()

    data class Data(val blockchainNetwork: BlockchainNetwork) : BlockchainNetworkViewItem()
}