package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
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

private val AVATAR_HEIGHT_WIDTH = 100.dp

@Composable
fun ValidatorCard(
    validatorViewState: ValidatorViewState,
    modifier: Modifier
) {
    var palette by remember { mutableStateOf<Palette?>(null) }

    Box(
        modifier = modifier
            .height(200.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
            .background(
                brush = palette?.let { safePalette ->
                    val mostThreeColors = safePalette.swatches.sortedByDescending { it.population }.take(2)
                    return@let Brush.linearGradient(
                        mostThreeColors.map { Color(it.rgb) }
                    )
                } ?: Brush.linearGradient(
                    listOf(Color.Black, Color.Black)
                )
            )
    ) {
        if (validatorViewState.isLoading) {
            AvatarShimmer(Alignment.TopCenter)
        }

        GlideImage(
            modifier = Modifier
                .align(alignment = Alignment.TopCenter)
                .width(AVATAR_HEIGHT_WIDTH)
                .height(AVATAR_HEIGHT_WIDTH),
            imageModel = validatorViewState.validatorModel?.avatar,
            requestBuilder = {
                Glide.with(LocalContext.current.applicationContext)
                    .asDrawable()
                    .applyDefaults()
            },
            requestOptions = {
                RequestOptions.circleCropTransform()
            },
            circularReveal = CircularReveal(duration = 600),
            loading = {
                AvatarShimmer(Alignment.Center)
            },
            bitmapPalette = BitmapPalette { palette = it }
        )

        Text(
            text = validatorViewState.validatorModel?.title ?: "default text",
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .padding(top = 30.dp)
                .placeholder(
                    visible = validatorViewState.isLoading,
                    color = Color.Gray,
                    // optional, defaults to RectangleShape
                    shape = RoundedCornerShape(4.dp),
                    highlight = PlaceholderHighlight.shimmer(
                        highlightColor = Color.White,
                    )
                )
        )
    }
}

@Composable
fun BoxScope.AvatarShimmer(
    alignment: Alignment
) {
    Text(
        text = "default text",
        modifier = Modifier
            .align(alignment)
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