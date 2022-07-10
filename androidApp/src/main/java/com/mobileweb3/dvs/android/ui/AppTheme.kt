package com.mobileweb3.dvs.android.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PrimaryColor = Color(0xff735095)

private val LightColors = lightColors(
    primary = PrimaryColor,
    background = Color.Black,
    onBackground = Color.White
)
private val DarkColors = darkColors(
    primary = PrimaryColor,
    onSecondary = Color.White,
    background = Color.Black
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) DarkColors else LightColors,
        content = {
            Surface(content = content)
        }
    )
}