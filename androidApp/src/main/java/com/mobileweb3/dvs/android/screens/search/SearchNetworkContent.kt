package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.mobileweb3.dvs.android.ui.composables.NetworksGrid
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

    NetworksGrid(
        blockchainNetworks = searchState.networks,
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        searchNetworkStore.dispatch(SearchNetworkAction.NetworkSelected(it))
    }
}

sealed class BlockchainNetworkViewItem {

    object Empty : BlockchainNetworkViewItem()

    data class Data(val blockchainNetwork: BlockchainNetwork) : BlockchainNetworkViewItem()
}