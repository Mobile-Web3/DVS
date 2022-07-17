package com.mobileweb3.dvs.android.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobileweb3.dvs.android.ui.composables.DefaultHeader
import com.mobileweb3.dvs.app.SearchNetworkStore
import com.mobileweb3.dvs.app.ValidatorDetailsAction
import com.mobileweb3.dvs.app.ValidatorDetailsStore

@Composable
fun SearchValidatorContent(
    searchNetworkStore: SearchNetworkStore,
    validatorDetailsStore: ValidatorDetailsStore,
    navController: NavHostController
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

        if (searchState.value.selectedNetwork == null) {
            SearchNetworkContent(searchState.value, searchNetworkStore)
        } else {
            SelectedNetworkView(searchState.value.selectedNetwork!!, searchNetworkStore)

            ResultValidatorListContent(
                searchState = searchState.value,
                modifier = Modifier.padding(
                    top = 4.dp,
                    start = 16.dp,
                    end = 16.dp
                )
            ) {
                validatorDetailsStore.dispatch(ValidatorDetailsAction.ValidatorSelected(it))
                navController.navigate("details")
            }
        }
    }
}