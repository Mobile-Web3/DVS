package com.mobileweb3.dvs.android.screens.search

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.screens.main.ValidatorCard
import com.mobileweb3.dvs.app.SearchNetworkState
import com.mobileweb3.dvs.app.SearchNetworkStore
import com.mobileweb3.dvs.app.ValidatorViewState
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel

@Composable
fun ResultValidatorListContent(
    searchState: SearchNetworkState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    onValidatorClicked: (ValidatorModel) -> Unit
) {
    val chunkedList = searchState.validatorsByNetwork.chunked(2)

    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        chunkedList.forEach { chunk ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                chunk.forEach { validatorModel ->
                    ValidatorCard(
                        validatorViewState = ValidatorViewState(
                            isLoading = false,
                            validatorModel = validatorModel
                        ),
                        modifier = Modifier
                            .padding(2.dp)
                            .weight(1f),
                        onValidatorClicked = { model ->
                            onValidatorClicked(model!!)
                        }
                    )
                }

                val emptyCells = 2 - chunk.size
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