package com.mobileweb3.dvs.android.screens.voting

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ValidatorVotesHeader(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }

        Text(
            modifier = Modifier.padding(
                top = 8.dp,
                end = 16.dp
            ),
            color = Color.White,
            text = "Note: click on proposal to see detailed information.\n" +
                    "Click on validator vote in top right to see the vote transaction."
        )
    }
}