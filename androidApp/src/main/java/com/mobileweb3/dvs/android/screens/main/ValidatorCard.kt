package com.mobileweb3.dvs.android.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.palette.graphics.Palette
import com.mobileweb3.dvs.android.ui.composables.Avatar
import com.mobileweb3.dvs.android.ui.composables.AvatarShimmer
import com.mobileweb3.dvs.android.ui.composables.ValidatorDescription
import com.mobileweb3.dvs.android.ui.composables.ValidatorTitle
import com.mobileweb3.dvs.android.ui.composables.getGradientBrush
import com.mobileweb3.dvs.app.ValidatorViewState
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel

private val AVATAR_HEIGHT_WIDTH = 120.dp
val SPACER_HEIGHT = 8.dp

@Composable
fun ValidatorCard(
    validatorViewState: ValidatorViewState,
    modifier: Modifier,
    onValidatorClicked: (ValidatorModel?) -> Unit
) {
    var palette by remember { mutableStateOf<Palette?>(null) }

    Box(
        modifier = modifier
            .height(300.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
            .background(
                brush = getGradientBrush(palette, validatorViewState.validatorModel?.avatar),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onValidatorClicked(validatorViewState.validatorModel) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(SPACER_HEIGHT))

            if (validatorViewState.isLoading) {
                AvatarShimmer(AVATAR_HEIGHT_WIDTH)
            } else {
                Avatar(
                    url = validatorViewState.validatorModel?.avatar,
                    widthHeightDp = AVATAR_HEIGHT_WIDTH,
                    onPaletteChanged = { palette = it }
                )
            }

            Spacer(modifier = Modifier.height(SPACER_HEIGHT))

            ValidatorTitle(
                validatorViewState = validatorViewState,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            ValidatorDescription(
                validatorViewState = validatorViewState
            )
        }
    }
}