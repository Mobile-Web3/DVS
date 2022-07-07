package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.app.MainStore
import com.mobileweb3.dvs.app.ValidatorViewState

@Composable
fun ValidatorsList(
    store: MainStore,
    columns: Int = 2,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val state = store.observeState().collectAsState()

    val chunkedList = state.value.validatorViewStates.chunked(columns)

    Column(
        modifier = modifier.verticalScroll(scrollState)
    ) {
        chunkedList.forEach { chunk ->
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                chunk.forEach { validatorViewState ->
                    ValidatorCard(
                        validatorViewState = validatorViewState,
                        modifier = Modifier
                            .padding(2.dp)
                            .weight(1f)
                    )
                }

                val emptyCells = columns - chunk.size
                if (emptyCells > 0) {
                    Spacer(modifier = Modifier.weight(emptyCells.toFloat()))
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(contentPadding.calculateEndPadding(LocalLayoutDirection.current))
                )
            }
        }
    }
}