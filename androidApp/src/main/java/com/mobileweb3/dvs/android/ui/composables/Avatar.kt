package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mobileweb3.dvs.android.utils.applyDefaults
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.skydoves.landscapist.palette.BitmapPalette

@Composable
fun Avatar(
    url: String?,
    widthHeightDp: Dp,
    onPaletteChanged: ((Palette) -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    GlideImage(
        modifier = modifier
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(100.dp))
            .width(widthHeightDp)
            .height(widthHeightDp),
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
                AvatarShimmer(widthHeightDp)
            }
        },
        bitmapPalette = BitmapPalette { onPaletteChanged?.invoke(it) }
    )
}