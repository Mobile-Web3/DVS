package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette

fun getGradientBrush(palette: Palette?): Brush {
    return palette?.let { safePalette ->
        val mostThreeColors = safePalette.swatches
            .sortedByDescending { it.population }
            .take(3)
        return@let Brush.linearGradient(
            mostThreeColors.map { Color(it.rgb) }
        )
    } ?: Brush.linearGradient(
        listOf(Color.Black, Color.Black)
    )
}