package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun FindValidatorView(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .fillMaxWidth()
            .clickable {
                navController.navigate("search")
            }
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.then(Modifier.size(24.dp)),
            onClick = {
                navController.navigate("search")
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search"
            )
        }

        Text(
            modifier = Modifier.padding(
                start = 8.dp,
                bottom = 2.dp
            ),
            text = "Search by network",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            modifier = Modifier.then(Modifier.size(24.dp)),
            onClick = {
                navController.navigate("info")
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Info"
            )
        }
    }
}