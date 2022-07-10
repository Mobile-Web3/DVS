package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconWithHtmlLink(
    iconTag: String,
    link: String
) {
    val uriHandler = LocalUriHandler.current

    val iconRes = IconResources.from(iconTag)
    if (iconRes != null) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = iconTag,
            modifier = Modifier
                .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(100.dp))
                .clip(RoundedCornerShape(100.dp))
                .clickable { uriHandler.openUri(link) }
        )
    } else {
        TextWithHtml(
            textWithHtml = link.toHtmlLink(iconTag),
            modifier = Modifier
        )
    }
}

fun String.toHtmlLink(title: String): String {
    return "<a href=\"$this\" rel=\"nofollow\">$title</a>"
}