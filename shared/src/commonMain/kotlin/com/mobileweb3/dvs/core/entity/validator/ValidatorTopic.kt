package com.mobileweb3.dvs.core.entity.validator

data class ValidatorTopic(
    val title: String,
    val topicContent: List<ValidatorTopicContent>,
    val topicIndex: Int // for ios lol
)

sealed class ValidatorTopicContent {

    data class SimpleText(val text: String) : ValidatorTopicContent()

    data class ButtonsWithRefFlow(
        val buttons: List<ButtonWithRef>
    ) : ValidatorTopicContent()

    data class MainNetworks(val networks: List<ValidatorNetwork>) : ValidatorTopicContent()

    data class VotingNetworks(val networks: List<ValidatorNetwork>) : ValidatorTopicContent()

    data class Contacts(
        val contacts: List<Contact>
    ) : ValidatorTopicContent()
}

data class ButtonWithRef(
    val text: String,
    val reference: String?,
)