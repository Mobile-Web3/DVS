package com.mobileweb3.dvs.android.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mobileweb3.dvs.android.ui.AppTheme
import com.mobileweb3.dvs.app.ValidatorListStore

@Preview
@Composable
private fun ValidatorsListScreenPreview() {
    AppTheme {
        ValidatorsListContent(ValidatorListStore())
    }
}