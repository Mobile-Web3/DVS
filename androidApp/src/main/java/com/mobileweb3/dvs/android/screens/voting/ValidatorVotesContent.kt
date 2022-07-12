package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.app.ValidatorVotesStore
import com.mobileweb3.dvs.core.entity.RequestStatus

@Composable
fun ValidatorVotesContent(
    validatorVotesStore: ValidatorVotesStore
) {
    val votesState = validatorVotesStore.observeState().collectAsState(null)
    if (votesState.value == null) {
        return
    }

    LazyVerticalGrid(
        modifier = Modifier.padding(top = 24.dp),
        columns = GridCells.Fixed(1)
    ) {
        val itemsCount = when (votesState.value!!.proposals) {
            is RequestStatus.Data -> {
                2
            }
            is RequestStatus.Error -> {
                1
            }
            is RequestStatus.Loading -> {
                1
            }
        }
        items(itemsCount) {
            when (votesState.value!!.proposals) {
                is RequestStatus.Data -> {
                    Text(text = "Data")
                }
                is RequestStatus.Error -> {
                    Text(text = "Error")
                }
                is RequestStatus.Loading -> {
                    Text(text = "Loading")
                }
            }
        }
    }
}