package com.mobileweb3.dvs.android.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.palette.graphics.Palette
import com.mobileweb3.dvs.android.ui.composables.Avatar
import com.mobileweb3.dvs.android.ui.composables.NetworksGrid
import com.mobileweb3.dvs.android.ui.composables.TextWithHtml
import com.mobileweb3.dvs.android.ui.composables.ValidatorTitle
import com.mobileweb3.dvs.android.ui.composables.getGradientBrush
import com.mobileweb3.dvs.app.ValidatorDetailsAction
import com.mobileweb3.dvs.app.ValidatorDetailsStore
import com.mobileweb3.dvs.app.ValidatorViewState
import com.mobileweb3.dvs.app.ValidatorVotesAction
import com.mobileweb3.dvs.app.ValidatorVotesStore
import com.mobileweb3.dvs.core.entity.validator.ValidatorTopicContent

private val AVATAR_HEIGHT_WIDTH = 180.dp

@Composable
fun ValidatorDetailsContent(
    validatorDetailsStore: ValidatorDetailsStore,
    validatorVotesStore: ValidatorVotesStore,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val validatorModelState = validatorDetailsStore.observeState().collectAsState(null)
    val validatorModel = validatorModelState.value?.validatorModel ?: return

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        var palette by remember { mutableStateOf<Palette?>(null) }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(brush = getGradientBrush(palette, validatorModel.avatar))
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Avatar(
                url = validatorModel.avatar,
                widthHeightDp = AVATAR_HEIGHT_WIDTH,
                onPaletteChanged = { palette = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ValidatorTitle(
                validatorViewState = ValidatorViewState(
                    isLoading = false,
                    validatorModel = validatorModel
                ),
                modifier = Modifier
            )
        }

        val topics = validatorModel.getTopics()
        var content: List<ValidatorTopicContent>? by remember {
            mutableStateOf(
                try {
                    topics[validatorModelState.value?.selectedTopicIndex ?: 0].topicContent
                } catch (ex: Exception) {
                    null
                }
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
                .horizontalScroll(
                    state = rememberScrollState(),
                    enabled = true
                )
        ) {
            topics.forEachIndexed { index, validatorTopic ->
                Button(
                    onClick = {
                        validatorDetailsStore.dispatch(ValidatorDetailsAction.TopicSelected(index))
                        content = validatorTopic.topicContent
                    },
                    modifier = modifier,
                ) {
                    Text(
                        text = validatorTopic.title,
                        fontSize = 20.sp
                    )
                }

                if (index != topics.lastIndex) {
                    Spacer(modifier = modifier.width(8.dp))
                }
            }
        }

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
            //                .verticalScroll(
            //                    state = rememberScrollState(),
            //                    enabled = true
            //                )
        ) {
            val uriHandler = LocalUriHandler.current
            val context = LocalContext.current

            content?.forEach { topicContent ->
                when (topicContent) {
                    is ValidatorTopicContent.SimpleText -> {
                        TextWithHtml(
                            textWithHtml = topicContent.text,
                            modifier = modifier
                        )
                    }
                    is ValidatorTopicContent.ButtonsWithRefFlow -> {
                        ButtonsRow(
                            topicContent,
                            uriHandler,
                            context
                        )
                    }
                    is ValidatorTopicContent.VotingNetworks -> {
                        NetworksGrid(
                            blockchainNetworks = topicContent.networks.map { it.blockchainNetwork },
                        ) { blockchainNetwork ->
                            validatorVotesStore.dispatch(
                                ValidatorVotesAction.NetworkSelected(
                                    validatorModel,
                                    topicContent.networks.find { it.blockchainNetwork == blockchainNetwork }!!
                                )
                            )
                            navController.navigate("voting")
                        }
                    }
                    is ValidatorTopicContent.MainNetworks -> {
                        NetworksGrid(
                            blockchainNetworks = topicContent.networks.map { it.blockchainNetwork },
                        ) { blockchainNetwork ->
                            val validatorNetwork =
                                topicContent.networks.find { it.blockchainNetwork == blockchainNetwork }!!
                            uriHandler.openUri(validatorNetwork.getValidatorPageLink())
                        }
                    }
                    is ValidatorTopicContent.Contacts -> {
                        RowValidatorContacts(topicContent.contacts, modifier.padding(bottom = 8.dp))
                    }
                }
            }
        }
    }
}