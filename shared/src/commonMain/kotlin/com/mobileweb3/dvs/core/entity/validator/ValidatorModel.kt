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

    val validatingNetworksCount = mainNets.size + testNets.size + genesisNets.size
    val otherActivities = otherProjects.size + contributionsSize()

    private fun contributionsSize(): Int {
        var result = 0
        contributionsTypes.forEach { result += it.contributions.size }
        return result
    }

    fun validatingNetwork(network: BlockchainNetwork): Boolean {
        return mainNets.any { it.blockchainNetwork == network } ||
                genesisNets.any { it.blockchainNetwork == network } ||
                testNets.any { it.blockchainNetwork == network }
    }

    fun getSmallDescription(): String {
        val stringBuilder = StringBuilder()

        if (validatingNetworksCount != 0) {
            stringBuilder
                .append("Validator $validatingNetworksCount")
        }

        if (ambassadorPrograms.isNotEmpty()) {
            if (stringBuilder.isNotEmpty()) {
                stringBuilder.append("\n")
            }

            stringBuilder
                .append("Ambassador ${ambassadorPrograms.size}")
        }

        if (otherActivities != 0) {
            if (stringBuilder.isNotEmpty()) {
                stringBuilder.append("\n")
            }

            stringBuilder
                .append("Activities $otherActivities")
        }

        return stringBuilder.toString()
    }

    fun getTopics(): List<ValidatorTopic> {
        val resultList = mutableListOf<ValidatorTopic>()

        if (description.isNotEmpty() || contacts.isNotEmpty()) {
            val resultTopicsList = mutableListOf<ValidatorTopicContent>()

            if (contacts.isNotEmpty()) {
                resultTopicsList.add(
                    ValidatorTopicContent.Contacts(contacts)
                )
            }

            if (description.isNotEmpty()) {
                resultTopicsList.add(ValidatorTopicContent.SimpleText(description))
            } else {
                resultTopicsList.add(ValidatorTopicContent.SimpleText("More info will be added soon..."))
            }

            resultList.add(
                ValidatorTopic(
                    title = "Bio",
                    topicContent = resultTopicsList,
                    topicIndex = resultList.count()
                )
            )
        }

        val cosmosNetworks = mainNets.filter { it.blockchainNetwork.isCosmosNetwork }
        if (cosmosNetworks.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "Voting",
                    topicContent = listOf(ValidatorTopicContent.VotingNetworks(cosmosNetworks)),
                    topicIndex = resultList.count()
                )
            )
        }

        if (mainNets.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "MainNets",
                    topicContent = listOf(ValidatorTopicContent.MainNetworks(mainNets)),
                    topicIndex = resultList.count()
                )
            )
        }

        if (testNets.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "TestNets",
                    topicContent = listOf(ValidatorTopicContent.MainNetworks(testNets)),
                    topicIndex = resultList.count()
                )
            )
        }

        if (ambassadorPrograms.isNotEmpty()) {
            resultList.add(
                ValidatorTopic(
                    title = "Ambassador",
                    topicContent = listOf(
                        ValidatorTopicContent.ButtonsWithRefFlow(
                            ambassadorPrograms.map { program ->
                                ButtonWithRef(
                                    text = program.title,
                                    reference = program.link
                                )
                            }
                        )
                    ),
                    topicIndex = resultList.count()
                )
            )
        }

        otherProjects.forEach { otherProject ->
            if (otherProject.projects.isNotEmpty()) {
                resultList.add(
                    ValidatorTopic(
                        title = otherProject.topic,
                        topicContent = listOf(
                            ValidatorTopicContent.ButtonsWithRefFlow(
                                otherProject.projects.map { project ->
                                    ButtonWithRef(
                                        text = project.title,
                                        reference = project.link
                                    )
                                }
                            )
                        ),
                        topicIndex = resultList.count()
                    )
                )
            }
        }

        contributionsTypes.forEach { contributions ->
            if (contributions.contributions.isNotEmpty()) {
                resultList.add(
                    ValidatorTopic(
                        title = contributions.type,
                        topicContent = listOf(
                            ValidatorTopicContent.ButtonsWithRefFlow(
                                contributions.contributions.map { contribution ->
                                    ButtonWithRef(
                                        text = contribution.label,
                                        reference = contribution.link
                                    )
                                }
                            )
                        ),
                        topicIndex = resultList.count()
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
                    },
                    topicIndex = resultList.count()
                )
            )
        }

        return resultList
    }

    //transform <a href="https://koinsortium.com/">consortium</a>
    //into [consortium](https://koinsortium.com/)
    fun transformTextWithLinksForIos(text: String): String {
        if (!text.contains("<a href=")) {
            return text
        }

        var resultDescription = text

        if (resultDescription.contains("<a href=")) {
            val indexOfOpenHrefTagStart = resultDescription.indexOf("<a href=")

            val indexOfLinkStart = indexOfOpenHrefTagStart + 1
            val indexOfOpenHrefTagEnd = resultDescription.indexOf(">", indexOfLinkStart)

            val indexOfCloseHrefTagStart = resultDescription.indexOf("</a>")
            val linkTitle = resultDescription.substring(indexOfOpenHrefTagEnd + 1, indexOfCloseHrefTagStart)

            resultDescription = resultDescription.replace("<a href=", "[$linkTitle](")
            resultDescription = resultDescription.replace(">$linkTitle</a>", ")")
        }

        return resultDescription
    }
}

data class ValidatorNetwork(
    val blockchainNetwork: BlockchainNetwork,
    val validatorAddress: String? = null,
    val walletAddress: String? = null,
) {

    override fun toString(): String {
        return if (validatorAddress != null) {
            "<a href=\"${blockchainNetwork.validatorsListRef}/${validatorAddress}\">${blockchainNetwork.title}</a>"
        } else {
            "- ${blockchainNetwork.title}"
        }
    }

    fun getValidatorPageLink(): String {
        return if (validatorAddress != null) {
            "${blockchainNetwork.validatorsListRef}/${validatorAddress}"
        } else {
            "${blockchainNetwork.validatorsListRef}"
        }
    }

    fun getValidatorTransactionsLink(): String {
        return if (walletAddress != null) {
            "${blockchainNetwork.getTransactionsRef}/${walletAddress}"
        } else {
            "${blockchainNetwork.validatorsListRef}"
        }
    }

    fun getValidatorStatusLink(): String {
        return if (validatorAddress != null) {
            "${blockchainNetwork.validatorInfoRef}/${validatorAddress}"
        } else {
            "${blockchainNetwork.validatorInfoRef}"
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
)

data class Contributions(
    val type: String, //tech,community,other
    val contributions: List<Contribution>
)

data class Contribution(
    val label: String,
    val link: String? = null
)

data class Contact(
    val type: String,
    val link: String
)

data class OtherInfo(
    val title: String,
    val body: String
)

