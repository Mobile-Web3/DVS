package com.mobileweb3.dvs.android.screens.detail

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.mobileweb3.dvs.android.ui.composables.NetworkButton
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

@Composable
fun NetworkButtonsRow(
    networks: List<ValidatorNetwork>,
    topicsLastIndex: Int,
    onClick: (ValidatorNetwork) -> Unit
) {
    FlowRow {
        networks.forEachIndexed { index, network ->
            NetworkButton(network) {
                onClick(network)
            }

            if (index != topicsLastIndex) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}