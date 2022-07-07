package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.core.entity.ValidatorModel

@Composable
fun ValidatorCard(
    validatorModel: ValidatorModel,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .height(200.dp)
    ) {
        Text(
            text = validatorModel.title,
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}