package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
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
            .fillMaxWidth()
            .height(40.dp)
            .clickable {
                navController.navigate("search")
            }
            .padding(
                end = 16.dp,
                bottom = 8.dp,
                top = 8.dp
            )
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
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
            text = "Search by network",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }
}