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
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

@Composable
fun ProposalShimmerView() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colors.primary, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Proposal 00",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.placeholder(
                    visible = true,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp),
                    highlight = PlaceholderHighlight.shimmer(
                        highlightColor = Color.White,
                    )
                )
            )
            Text(
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        end = 100.dp
                    )
                    .placeholder(
                        visible = true,
                        color = Color.Gray,
                        shape = RoundedCornerShape(4.dp),
                        highlight = PlaceholderHighlight.shimmer(
                            highlightColor = Color.White,
                        )
                    ),
                text = "item.validatorVote.proposal.title",
                style = MaterialTheme.typography.subtitle1,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ProposalStatusShimmerView()

                ProposalVotesShimmerView()
            }
        }

        Text(
            text = "Yes",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .placeholder(
                    visible = true,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp),
                    highlight = PlaceholderHighlight.shimmer(
                        highlightColor = Color.White,
                    )
                )
                .padding(12.dp)
        )
    }
}