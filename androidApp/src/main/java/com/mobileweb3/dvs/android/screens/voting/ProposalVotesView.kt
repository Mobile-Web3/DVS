package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.core.entity.proposal.ProposalPercentages
import com.mobileweb3.dvs.core.entity.validator.Vote

@Composable
fun ProposalVotesView(percentages: ProposalPercentages) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp)),
    ) {
        Text(
            text = "",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(percentages.yes.dp)
                .background(
                    color = Color(Vote.YES.color),
                )
                .padding(12.dp)
        )

        Text(
            text = "",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(percentages.no.dp)
                .background(
                    color = Color(Vote.NO.color),
                )
                .padding(12.dp)
        )
        Text(
            text = "",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(percentages.noWithVeto.dp)
                .background(
                    color = Color(Vote.NO_WITH_VETO.color),
                )
                .padding(12.dp)
        )
        Text(
            text = "",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .width(percentages.abstain.dp)
                .background(
                    color = Color(Vote.ABSTAIN.color),
                )
                .padding(12.dp)
        )
    }
}