package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.R
import com.mobileweb3.dvs.app.ValidatorListStore

@Composable
fun ValidatorsListContent(
    store: ValidatorListStore,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.dvs_background),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        ValidatorsList(store = store)
    }
}