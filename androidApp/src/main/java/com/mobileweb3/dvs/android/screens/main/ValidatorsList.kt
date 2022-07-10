package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import com.mobileweb3.dvs.android.screens.detail.ValidatorDetailsScreen
import com.mobileweb3.dvs.app.ValidatorListStore

@Composable
fun ValidatorsList(
    store: ValidatorListStore,
) {
    val state = store.observeState().collectAsState()

    val navigator = LocalNavigator.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            items(state.value.validatorViewStates) {
                ValidatorCard(
                    validatorViewState = it,
                    modifier = Modifier
                        .padding(2.dp),
                    onValidatorClicked = { model ->
                        model?.let { safeModel -> navigator?.push(ValidatorDetailsScreen(safeModel)) }
                    }
                )
            }
        }
    )
}