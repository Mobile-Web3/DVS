package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.mobileweb3.dvs.android.utils.applyDefaults
import com.mobileweb3.dvs.app.ValidatorViewState
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.BitmapPalette

private val AVATAR_HEIGHT_WIDTH = 120.dp
private val SPACER_HEIGHT = 8.dp

@Composable
fun ValidatorCard(
    validatorViewState: ValidatorViewState,
    modifier: Modifier
) {
    var palette by remember { mutableStateOf<Palette?>(null) }

    Box(
        modifier = modifier
            .height(300.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
            .background(
                brush = palette?.let { safePalette ->
                    val mostThreeColors = safePalette.swatches
                        .sortedByDescending { it.population }
                        .take(3)
                    return@let Brush.linearGradient(
                        mostThreeColors.map { Color(it.rgb) }
                    )
                } ?: Brush.linearGradient(
                    listOf(Color.Black, Color.Black)
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(SPACER_HEIGHT))

            if (validatorViewState.isLoading) {
                AvatarShimmer()
            } else {
                Avatar(
                    url = validatorViewState.validatorModel?.avatar,
                    onPaletteChanged = { palette = it }
                )
            }

            Spacer(modifier = Modifier.height(SPACER_HEIGHT))

            ValidatorTitle(
                validatorViewState = validatorViewState,
                colorPalette = palette
            )
        }
    }
}

@Composable
fun AvatarShimmer() {
    Text(
        text = "default text",
        modifier = Modifier
            .width(AVATAR_HEIGHT_WIDTH)
            .height(AVATAR_HEIGHT_WIDTH)
            .placeholder(
                visible = true,
                color = Color.Gray,
                shape = RoundedCornerShape(100.dp),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = Color.White,
                )
            )
    )
}

@Composable
fun Avatar(
    url: String?,
    onPaletteChanged: (Palette) -> Unit
) {
    GlideImage(
        modifier = Modifier
            .width(AVATAR_HEIGHT_WIDTH)
            .height(AVATAR_HEIGHT_WIDTH),
        imageModel = url,
        requestBuilder = {
            Glide.with(LocalContext.current.applicationContext)
                .asDrawable()
                .applyDefaults()
        },
        requestOptions = { RequestOptions.circleCropTransform() },
        circularReveal = CircularReveal(duration = 600),
        loading = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AvatarShimmer()
            }
        },
        bitmapPalette = BitmapPalette { onPaletteChanged(it) }
    )
}

@Composable
fun ValidatorTitle(
    validatorViewState: ValidatorViewState,
    colorPalette: Palette?
) {
    Text(
        text = validatorViewState.validatorModel?.title ?: "default text",
        color = colorPalette?.let { Color(colorPalette.mutedSwatch!!.bodyTextColor) } ?: Color.White,
        maxLines = 2,
        textAlign = TextAlign.Center,
        style = typography.h6,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .placeholder(
                visible = validatorViewState.isLoading,
                color = Color.Gray,
                shape = RoundedCornerShape(4.dp),
                highlight = PlaceholderHighlight.shimmer(
                    highlightColor = Color.White,
                )
            )
    )
}