package com.mobileweb3.basic_kmm_sample.android.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mobileweb3.basic_kmm_sample.android.ui.AppTheme
import com.mobileweb3.basic_kmm_sample.app.MainStore

@Preview
@Composable
private fun MainScreenPreview() {
    AppTheme {
        MainScreen(MainStore())
    }
}