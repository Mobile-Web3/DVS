package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
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

    val uriHandler = LocalUriHandler.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp
            )
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(votesState.value!!.proposals.toViewItems()) { item ->
                when (item) {
                    ProposalViewItem.Loading -> {
                        Text(text = "Loading...")
                    }
                    ProposalViewItem.Error -> {
                        Text(text = "Error...")
                    }
                    is ProposalViewItem.Data -> {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(2.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
                                .clickable {
                                    val transactionExploreRef = votesState.value!!.network!!.blockchainNetwork.exploreTransactionRef
                                    uriHandler.openUri("$transactionExploreRef/${item.validatorVote.txhash}")
                                }
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(
                                        start = 16.dp,
                                        end = 80.dp,
                                        top = 16.dp,
                                        bottom = 16.dp
                                    )
                            ) {
                                Text(
                                    text = "Proposal ${item.validatorVote.proposal.id}",
                                    style = MaterialTheme.typography.h5,
                                    color = MaterialTheme.colors.onPrimary
                                )
                                Text(
                                    text = "${item.validatorVote.proposal.title}",
                                    style = MaterialTheme.typography.subtitle1,
                                    color = MaterialTheme.colors.onPrimary
                                )

                            }
                        }

                    }
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