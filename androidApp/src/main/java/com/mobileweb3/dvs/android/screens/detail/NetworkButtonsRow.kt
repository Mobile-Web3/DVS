package com.mobileweb3.dvs.android.screens.detail

import androidx.compose.runtime.Composable
import com.mobileweb3.dvs.android.ui.composables.DefaultFlowRow
import com.mobileweb3.dvs.android.ui.composables.NetworkButton
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

@Composable
fun NetworkButtonsRow(
    networks: List<ValidatorNetwork>,
    onClick: (ValidatorNetwork) -> Unit
) {
    DefaultFlowRow {
        networks.forEach { network ->
            NetworkButton(network) {
                onClick(network)
            }
        }
    }
}