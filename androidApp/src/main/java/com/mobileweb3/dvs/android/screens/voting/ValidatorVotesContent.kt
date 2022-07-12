package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.app.ValidatorVotesStore
import com.mobileweb3.dvs.core.entity.RequestStatus
import com.mobileweb3.dvs.core.entity.validator.ValidatorVote

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
        items(votesState.value!!.proposals.toViewItems()) {
            when (it) {
                ProposalViewItem.Loading -> {
                    Text(text = "Loading...")
                }
                ProposalViewItem.Error -> {
                    Text(text = "Error...")
                }
                is ProposalViewItem.Data -> {
                    Text(text = "${it.validatorVote.proposal.title} : ${it.validatorVote.vote.name}")
                }
            }
        }
    }
}

fun RequestStatus<List<ValidatorVote>>.toViewItems(): List<ProposalViewItem> {
    return when (this) {
        is RequestStatus.Loading -> {
            listOf(ProposalViewItem.Loading, ProposalViewItem.Loading, ProposalViewItem.Loading, ProposalViewItem.Loading)
        }
        is RequestStatus.Error -> {
            listOf(ProposalViewItem.Error)
        }
        is RequestStatus.Data -> {
            data.map { ProposalViewItem.Data(it) }
        }
    }
}

sealed class ProposalViewItem {

    object Loading : ProposalViewItem()

    object Error : ProposalViewItem()

    data class Data(val validatorVote: ValidatorVote) : ProposalViewItem()
}