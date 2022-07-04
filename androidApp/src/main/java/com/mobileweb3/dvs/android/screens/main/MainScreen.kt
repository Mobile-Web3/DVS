package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.app.MainAction
import com.mobileweb3.dvs.app.MainStore

@Composable
fun MainScreen(
    store: MainStore
) {
    val state = store.observeState().collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Count: ${state.value.count}",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentHeight()
                    .clickable { store.dispatch(MainAction.Click) },
            )
        }

        Text(
            text = "by Mobile Web3",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .clickable { store.dispatch(MainAction.Click) }
        )
    }
}