package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobileweb3.dvs.android.ui.composables.DefaultHeader
import com.mobileweb3.dvs.app.ValidatorDetailsStore
import com.mobileweb3.dvs.app.ValidatorListStore

@Composable
fun ValidatorsListContent(
    validatorListStore: ValidatorListStore,
    validatorDetailsStore: ValidatorDetailsStore,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = 24.dp,
            )
    ) {
        DefaultHeader()

        FindValidatorView(
            navController = navController
        )

        ValidatorsList(
            validatorListStore = validatorListStore,
            validatorDetailsStore = validatorDetailsStore,
            navController = navController,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        )
    }
}