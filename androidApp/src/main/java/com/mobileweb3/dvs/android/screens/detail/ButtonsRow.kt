package com.mobileweb3.dvs.android.screens.detail

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.mobileweb3.dvs.core.entity.validator.ValidatorTopicContent

@Composable
fun ButtonsRow(
    topicContent: ValidatorTopicContent.ButtonsWithRefFlow,
    uriHandler: UriHandler,
    context: Context,
    topicsLastIndex: Int
) {
    FlowRow {
        topicContent.buttons.forEachIndexed { index, content ->
            Button(
                modifier = Modifier.height(56.dp),
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
                    fontSize = 20.sp
                )
            }

            if (index != topicsLastIndex) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}