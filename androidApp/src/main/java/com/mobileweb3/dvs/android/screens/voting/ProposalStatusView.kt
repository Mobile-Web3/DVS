package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.core.entity.proposal.ProposalStatus

@Composable
fun ProposalStatusView(proposalStatus: ProposalStatus) {
    Text(
        text = proposalStatus.title,
        fontWeight = FontWeight.Bold,
        color = Color(proposalStatus.textColor),
        modifier = Modifier
            .background(
                color = Color(proposalStatus.backgroundColor),
                shape = RoundedCornerShape(100.dp)
            )
            .padding(12.dp)
    )
}