package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.ui.composables.DefaultHeader
import com.mobileweb3.dvs.app.SearchNetworkStore

@Composable
fun SearchValidatorContent(searchNetworkStore: SearchNetworkStore) {
    val searchState = searchNetworkStore.observeState().collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp,
            )
    ) {
        DefaultHeader()

        if (searchState.value.selectedNetwork == null) {
            SearchNetworkContent(searchState.value, searchNetworkStore)
        } else {
            SelectedNetworkView(searchState.value.selectedNetwork!!, searchNetworkStore)

            ResultValidatorListContent(searchState.value, searchNetworkStore)
        }
    }
}