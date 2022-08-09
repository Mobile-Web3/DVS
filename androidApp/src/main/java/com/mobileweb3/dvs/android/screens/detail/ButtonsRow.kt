package com.mobileweb3.dvs.android.screens.detail

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobileweb3.dvs.android.ui.composables.DefaultFlowRow
import com.mobileweb3.dvs.core.entity.validator.ValidatorTopicContent

@Composable
fun ButtonsRow(
    topicContent: ValidatorTopicContent.ButtonsWithRefFlow,
    uriHandler: UriHandler,
    context: Context
) {
    DefaultFlowRow {
        topicContent.buttons.forEach { content ->
            Button(
                modifier = Modifier.height(40.dp),
                shape = RoundedCornerShape(30.dp),
                onClick = {
                    if (content.reference != null) {
                        uriHandler.openUri(content.reference!!)
                    } else {
                        Toast.makeText(context, "There is no reference for ${content.text}", Toast.LENGTH_LONG).show()
                    }
                }
            ) {
                Text(
                    modifier = Modifier,
                    text = content.text,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp
                )
            }
        }
    }
}