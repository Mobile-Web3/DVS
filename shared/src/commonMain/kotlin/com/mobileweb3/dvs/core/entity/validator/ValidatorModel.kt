package com.mobileweb3.dvs.core.entity.validator

data class ValidatorModel(
    val title: String,
    val avatar: String,
    val description: String,
    val mainNets: List<ValidatorNetwork> = emptyList(),
    val testNets: List<ValidatorNetwork> = emptyList(),
    val genesisNets: List<ValidatorNetwork> = emptyList(),
    val otherProjects: List<OtherProjects> = emptyList(),
    val ambassadorPrograms: List<Project> = emptyList(),
    val contributionsTypes: List<Contributions> = emptyList(),
    val contacts: List<Contact> = emptyList(),
    val otherInfo: List<OtherInfo> = emptyList()
) {
    private val validatingNetworksCount = mainNets.size + testNets.size + genesisNets.size
    private val otherActivities = otherProjects.size + contributionsTypes.size

    fun getSmallDescription(): String {
        val networksCount = validatingNetworksCount
        val networksWord = if (networksCount == 1) {
            "network"
        } else {
            "networks"
        }

        val stringBuilder = StringBuilder()

        if (networksCount != 0) {
            stringBuilder
                .append("Validating ")
                .append("$networksCount $networksWord")
                .append("\n")
        }

        val ambassadorsCount = ambassadorPrograms.size
        val ambassadorsWord = if (ambassadorsCount == 1) {
            "project"
        } else {
            "projects"
        }

        if (ambassadorsCount != 0) {
            stringBuilder
                .append("Ambassador of ")
                .append("$ambassadorsCount $ambassadorsWord")
                .append("\n")
        }

        val otherActivitiesWord = if (otherActivities == 1) {
            "activity"
        } else {
            "activities"
        }

        if (otherActivities != 0) {
            stringBuilder
                .append("\n and $otherActivities other $otherActivitiesWord")
        }

        return stringBuilder.toString()
    }

    fun getTopics(): List<ValidatorTopic> {
        val resultList = mutableListOf<ValidatorTopic>()

        if (description.isNotEmpty() || contacts.isNotEmpty()) {
            val resultTopicsList = mutableListOf<ValidatorTopicContent>()

            if (description.isNotEmpty()) {
                resultTopicsList.add(ValidatorTopicContent.SimpleText(description))
            }

            if (contacts.isNotEmpty()) {
                resultTopicsList.add(
                    ValidatorTopicContent.Contacts(
                        contactsContent = contacts.map { contact ->
                            contact.type to contact.link
                        }
                    )
                )
            }

            resultList.add(
                ValidatorTopic(
                    title = "Bio",
                    topicContent = resultTopicsList
                )
            )
        }

        val cosmosNetworks = mainNets.filter { it.blockchainNetwork.isCosmosNetwork }
        if (cosmosNetworks.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "Voting",
                    topicContent = listOf(ValidatorTopicContent.VotingNetworks(cosmosNetworks))
                )
            )
        }

        if (mainNets.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "MainNets",
                    topicContent = listOf(ValidatorTopicContent.MainNetworks(mainNets))
                )
            )
        }

        if (testNets.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "TestNets",
                    topicContent = testNets.map { network ->
                        ValidatorTopicContent.SimpleText(network.toString())
                    }
                )
            )
        }

        if (ambassadorPrograms.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "Ambassador",
                    topicContent = ambassadorPrograms.map { program ->
                        ValidatorTopicContent.SimpleText(program.toString())
                    }
                )
            )
        }

        otherProjects.forEach { otherProject ->
            if (otherProject.projects.isNotEmpty()) {
                resultList.add(
                    ValidatorTopic(
                        title = otherProject.topic,
                        topicContent = otherProject.projects.map { project ->
                            ValidatorTopicContent.SimpleText(project.toString())
                        }
                    )
                )
            }
        }

        contributionsTypes.forEach { contributions ->
            if (contributions.contributions.isNotEmpty()) {
                resultList.add(
                    ValidatorTopic(
                        title = contributions.type,
                        topicContent = contributions.contributions.map { contribution ->
                            ValidatorTopicContent.SimpleText(contribution.toString())
                        }
                    )
                )
            }
        }

        if (otherInfo.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "Other Info",
                    topicContent = otherInfo.map { otherInfo ->
                        ValidatorTopicContent.SimpleText("${otherInfo.title}\n\n${otherInfo.body}\n\n")
                    }
                )
            )
        }

        return resultList
    }
}

data class ValidatorNetwork(
    val blockchainNetwork: BlockchainNetwork,
    val validatorAddress: String? = null
) {

    override fun toString(): String {
        return if (validatorAddress != null) {
            "<a href=\"${blockchainNetwork.validatorRef}/${validatorAddress}\">${blockchainNetwork.title}</a>"
        } else {
            "- ${blockchainNetwork.title}"
        }
    }

    fun getLink(): String {
        return if (validatorAddress != null) {
            "${blockchainNetwork.validatorRef}/${validatorAddress}"
        } else {
            "${blockchainNetwork.validatorRef}"
        }
    }
}

data class OtherProjects(
    val topic: String,
    val projects: List<Project>
)

data class Project(
    val title: String,
    val link: String? = null
) {
    override fun toString(): String {
        return if (link != null) {
            "- <a href=\"${link}\" rel=\"nofollow\">$title</a>"
        } else {
            "- $title"
        }
    }
}

data class Contributions(
    val type: String, //tech,community,other
    val contributions: List<Contribution>
)

data class Contribution(
    val label: String,
    val link: String? = null
) {
    override fun toString(): String {
        return if (link != null) {
            "- <a href=\"${link}\" rel=\"nofollow\">$label</a>"
        } else {
            "- $label"
        }
    }
}

data class Contact(
    val type: String,
    val link: String
)

data class OtherInfo(
    val title: String,
    val body: String
)

