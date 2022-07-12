package com.mobileweb3.dvs.android.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.mobileweb3.dvs.android.utils.textWithLinks

@Composable
fun TextWithHtml(
    textWithHtml: String,
    modifier: Modifier
) {
    val textWithLinks = textWithLinks(text = textWithHtml)
    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = textWithLinks,
        style = LocalTextStyle.current,
        modifier = modifier,
        onClick = { offset ->
            textWithLinks.getStringAnnotations(
                tag = "link_tag",
                start = offset,
                end = offset
            ).firstOrNull()?.let { stringAnnotation ->
                uriHandler.openUri(stringAnnotation.item)
            }
        }
    )
}