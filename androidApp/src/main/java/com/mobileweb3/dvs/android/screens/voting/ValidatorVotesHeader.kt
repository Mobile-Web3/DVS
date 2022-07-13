package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mobileweb3.dvs.android.ui.composables.Avatar
import com.mobileweb3.dvs.app.ValidatorVotesState

@Composable
fun ValidatorVotesHeader(
    value: ValidatorVotesState,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }

        Avatar(
            url = value.validatorModel!!.avatar,
            widthHeightDp = 70.dp
        )

        Spacer(modifier = Modifier.width(8.dp))

        Avatar(
            url = value.network!!.blockchainNetwork.imageRef,
            widthHeightDp = 70.dp
        )

        Spacer(modifier = Modifier.width(8.dp))

        Spacer(modifier = Modifier.weight(1f))

        val validatorTitle = value.validatorModel?.title
        val networkTitle = value.network?.blockchainNetwork?.title

        val spannedText = buildAnnotatedString {
            append("This is how ")
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("$validatorTitle ")
            }
            append("votes in ")
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("$networkTitle ")
            }
        }

        Text(
            text = spannedText,
            color = Color.White,
            modifier = Modifier.align(alignment = Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.width(8.dp))
    }
}