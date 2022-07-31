package com.mobileweb3.dvs.android.screens.info

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.R
import com.mobileweb3.dvs.android.ui.composables.DefaultHeader

@Composable
fun DvsInfoContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        DefaultHeader()

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(1f))

            val infiniteTransition = rememberInfiniteTransition()
            val rotation by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = -360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 3000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )

            Image(
                painter = painterResource(R.drawable.dvs_logo),
                contentDescription = null,
                modifier = Modifier.graphicsLayer(rotationZ = rotation)
            )

            Image(
                painter = painterResource(R.drawable.dvs_credo),
                contentDescription = null,
                modifier = Modifier.padding(top = 8.dp)
            )

            val uriHandler = LocalUriHandler.current
            Text(
                text = "validators.network",
                modifier = Modifier.clickable {
                    uriHandler.openUri("https://validators.network/")
                },
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Made by Mobile Web3",
                color = MaterialTheme.colors.primary,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}