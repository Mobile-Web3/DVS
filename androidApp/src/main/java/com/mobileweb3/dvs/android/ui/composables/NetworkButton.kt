package com.mobileweb3.dvs.android.ui.composables

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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mobileweb3.dvs.android.utils.applyDefaults
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NetworkButton(
    network: ValidatorNetwork,
    modifier: Modifier
) {
    val uriHandler = LocalUriHandler.current

    Button(
        onClick = { uriHandler.openUri(network.getLink()) },
        modifier = modifier,
        shape = RoundedCornerShape(30.dp)
    ) {
        GlideImage(
            modifier = Modifier
                .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(100.dp))
                .width(30.dp)
                .height(30.dp),
            imageModel = network.blockchainNetwork.imageRef,
            requestBuilder = {
                Glide.with(LocalContext.current.applicationContext)
                    .asDrawable()
                    .applyDefaults()
            },
            requestOptions = { RequestOptions.circleCropTransform() }
        )

        Spacer(modifier = modifier.width(4.dp))

        Text(
            text = network.blockchainNetwork.title,
            textDecoration = TextDecoration.Underline
        )
    }
}