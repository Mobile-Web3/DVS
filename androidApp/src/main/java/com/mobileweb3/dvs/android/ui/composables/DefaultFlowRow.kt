package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun DefaultFlowRow(
    content: @Composable () -> Unit
) {
    FlowRow(
        modifier = Modifier.padding(bottom = 16.dp),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        content()
    }
}