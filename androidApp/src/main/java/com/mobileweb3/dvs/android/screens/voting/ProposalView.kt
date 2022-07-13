package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.core.entity.proposal.ProposalStatus
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork

@Composable
fun ProposalView(item: ProposalViewItem.Data, network: BlockchainNetwork) {
    val uriHandler = LocalUriHandler.current

    val proposalStatus = ProposalStatus.from(item.validatorVote.proposal.proposal_status)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                val exploreProposalRef = network.exploreProposalRef
                uriHandler.openUri("${exploreProposalRef}/${item.validatorVote.proposal.id}")
            }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Proposal ${item.validatorVote.proposal.id}",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        end = 100.dp
                    ),
                text = "${item.validatorVote.proposal.title}",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onPrimary
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProposalStatusView(proposalStatus)

                val proposalPercents = item.validatorVote.proposal.getPercentages()
                ProposalVotesView(proposalPercents)
            }
        }

        Text(
            text = item.validatorVote.vote.string,
            style = MaterialTheme.typography.h5,
            color = Color(item.validatorVote.vote.color),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clickable {
                    val transactionExploreRef = network.exploreTransactionRef
                    uriHandler.openUri("$transactionExploreRef/${item.validatorVote.txhash}")
                }
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(12.dp)
        )
    }
}