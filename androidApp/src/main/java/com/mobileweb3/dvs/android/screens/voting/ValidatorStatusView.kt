package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.mobileweb3.dvs.android.ui.composables.Avatar
import com.mobileweb3.dvs.app.ValidatorVotesState
import com.mobileweb3.dvs.core.entity.validator.ValidatorStatus

@Composable
fun ValidatorStatusView(
    value: ValidatorVotesState,
    uriHandler: UriHandler
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        val validatorRank = value.validatorInfo.dataOrNull?.rank
        val validatorStatus = ValidatorStatus.from(value.validatorInfo.dataOrNull?.status)

        val spannedText = buildAnnotatedString {
            append("Rank: ")
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("${validatorRank ?: "UNKNOWN"}")
            }
            append("\n")
            append("Status: ")
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(validatorStatus)
            }
        }

        Text(
            text = spannedText,
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .placeholder(
                    visible = value.validatorInfo.isLoading,
                    color = Color.Gray,
                    shape = RoundedCornerShape(4.dp),
                    highlight = PlaceholderHighlight.shimmer(
                        highlightColor = Color.White,
                    )
                )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Spacer(modifier = Modifier.weight(1f))

        Avatar(
            url = value.validatorModel!!.avatar,
            widthHeightDp = 50.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .clickable {
                    value.network?.getValidatorPageLink()?.let {
                        uriHandler.openUri(it)
                    }
                }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Avatar(
            url = value.network!!.blockchainNetwork.imageRef,
            widthHeightDp = 50.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .clickable {
                    uriHandler.openUri(value.network?.blockchainNetwork!!.landingRef)
                }
        )

        Spacer(modifier = Modifier.width(8.dp))
    }
}