package com.mobileweb3.dvs.core.entity.validator

data class ValidatorTopic(
    val title: String,
    val topicContent: List<ValidatorTopicContent>
)

sealed class ValidatorTopicContent {

    data class SimpleText(val text: String) : ValidatorTopicContent()

    data class MainNetworks(val networks: List<ValidatorNetwork>) : ValidatorTopicContent()

    data class VotingNetworks(val networks: List<ValidatorNetwork>) : ValidatorTopicContent()

    data class Contacts(
        val contactsContent: List<Pair<String, String>>
    ) : ValidatorTopicContent()
}