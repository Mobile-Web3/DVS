package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.mobileweb3.dvs.android.R

@Composable
fun DefaultHeader() {
    Image(
        painter = painterResource(id = R.drawable.dvs_background),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
    )
}