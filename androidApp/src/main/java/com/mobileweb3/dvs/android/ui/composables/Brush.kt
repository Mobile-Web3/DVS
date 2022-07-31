package com.mobileweb3.dvs.android.ui.composables

import android.content.Context.MODE_PRIVATE
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.palette.graphics.Palette

@Composable
fun getGradientBrush(palette: Palette?, reference: String?): Brush {
    val sharedPreferences = LocalContext.current.getSharedPreferences("brush", MODE_PRIVATE)
    val savedColorsString = sharedPreferences.getString(reference, null)

    if (savedColorsString != null) {
        val savedColorsArray = savedColorsString.split(" ")
        val savedColors = savedColorsArray.map {
            Color(it.toInt())
        }
        return if (savedColors.size == 1) {
            Brush.linearGradient(listOf(savedColors[0], savedColors[0]))
        } else {
            Brush.linearGradient(savedColors)
        }
    }

    return palette?.let { safePalette ->
        val mostThreeColors = safePalette.swatches
            .sortedByDescending { it.population }
            .take(3)

        val colorsAsString = when (mostThreeColors.size) {
            1 -> {
                "${mostThreeColors[0].rgb}"
            }
            2 -> {
                "${mostThreeColors[0].rgb} ${mostThreeColors[1].rgb}}"
            }
            3 -> {
                "${mostThreeColors[0].rgb} ${mostThreeColors[1].rgb} ${mostThreeColors[2].rgb}"
            }
            else -> null
        }

        sharedPreferences
            .edit()
            .putString(reference, colorsAsString)
            .apply()

        return@let Brush.linearGradient(mostThreeColors.map { Color(it.rgb) })
    } ?: Brush.linearGradient(listOf(Color.Black, Color.Black))
}