package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobileweb3.dvs.app.ValidatorVotesStore
import com.mobileweb3.dvs.core.entity.RequestStatus
import com.mobileweb3.dvs.core.entity.validator.ValidatorVote

@Composable
fun ValidatorVotesContent(
    validatorVotesStore: ValidatorVotesStore,
    navController: NavHostController
) {
    val votesState = validatorVotesStore.observeState().collectAsState(null)
    if (votesState.value?.network == null || votesState.value?.validatorModel == null) {
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp
            )
    ) {
        ValidatorVotesHeader(votesState.value!!, navController, LocalUriHandler.current)

        Text(
            modifier = Modifier.padding(
                top = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
            color = Color.White,
            text = "Note: click on proposal to see detailed information.\n" +
                    "Click on validator vote in top right to see the vote transaction."
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(votesState.value!!.proposals.toViewItems()) { item ->
                when (item) {
                    ProposalViewItem.Loading -> {
                        ProposalShimmerView()
                    }
                    ProposalViewItem.Error -> {
                        Text(
                            text = "Loading proposals error. Maybe there are no proposals in ${votesState.value!!.network!!.blockchainNetwork.title}. Try later",
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                    is ProposalViewItem.Empty -> {
                        Text(
                            text = "There is no proposals yet in ${votesState.value!!.network!!.blockchainNetwork.name}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    is ProposalViewItem.Data -> {
                        ProposalView(
                            item = item,
                            network = votesState.value!!.network!!.blockchainNetwork
                        )
                    }
                }
            }
        }
    }
}

fun RequestStatus<List<ValidatorVote>>.toViewItems(): List<ProposalViewItem> {
    return when (this) {
        is RequestStatus.Loading -> {
            listOf(
                ProposalViewItem.Loading,
                ProposalViewItem.Loading
            )
        }
        is RequestStatus.Error -> {
            listOf(ProposalViewItem.Error)
        }
        is RequestStatus.Data -> {
            if (data.isEmpty()) {
                listOf(ProposalViewItem.Empty)
            } else {
                data.map { ProposalViewItem.Data(it) }
            }
        }
    }
}

sealed class ProposalViewItem {

    object Loading : ProposalViewItem()

    object Error : ProposalViewItem()

    data class Data(val validatorVote: ValidatorVote) : ProposalViewItem()

    object Empty : ProposalViewItem()
}