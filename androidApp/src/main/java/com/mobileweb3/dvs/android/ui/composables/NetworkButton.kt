package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mobileweb3.dvs.android.utils.applyDefaults
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NetworkButton(
    network: ValidatorNetwork,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick.invoke() },
        shape = RoundedCornerShape(30.dp)
    ) {
        GlideImage(
            modifier = Modifier
                .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(100.dp))
                .width(30.dp)
                .height(30.dp)
                .background(Color.White, RoundedCornerShape(100.dp)),
            imageModel = network.blockchainNetwork.imageRef,
            requestBuilder = {
                Glide.with(LocalContext.current.applicationContext)
                    .asDrawable()
                    .applyDefaults()
            },
            requestOptions = { RequestOptions.circleCropTransform() }
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = network.blockchainNetwork.title,
            fontSize = 16.sp
        )
    }
}