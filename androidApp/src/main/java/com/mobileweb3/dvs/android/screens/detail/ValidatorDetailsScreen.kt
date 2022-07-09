package com.mobileweb3.dvs.android.screens.detail

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.mobileweb3.dvs.core.entity.ValidatorModel
import org.koin.core.component.KoinComponent

class ValidatorDetailsScreen(private val validator: ValidatorModel) : Screen, KoinComponent {

    @Composable
    override fun Content() {
        ValidatorDetailsContent(validator)
    }
}