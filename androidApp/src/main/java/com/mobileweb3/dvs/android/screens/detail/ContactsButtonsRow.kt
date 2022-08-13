package com.mobileweb3.dvs.android.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileweb3.dvs.android.ui.composables.IconResources
import com.mobileweb3.dvs.core.entity.validator.ValidatorTopicContent

@Composable
fun ContactsButtonsRow(
    topicContent: ValidatorTopicContent.Contacts,
    uriHandler: UriHandler
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .horizontalScroll(
                state = rememberScrollState(),
                enabled = true
            )
    ) {
        Spacer(modifier = Modifier.width(8.dp))

        topicContent.contacts.forEachIndexed { index, content ->
            Button(
                modifier = Modifier.height(40.dp),
                shape = RoundedCornerShape(30.dp),
                onClick = {
                    uriHandler.openUri(content.link)
                }
            ) {
                val iconRes = IconResources.from(iconTag = content.type)
                iconRes?.let {
                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = content.type
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                }

                Text(
                    modifier = Modifier,
                    text = content.type,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp
                )
            }

            if (index != topicContent.contacts.lastIndex) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        Spacer(modifier = Modifier.width(8.dp))
    }
}