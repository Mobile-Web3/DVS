package com.mobileweb3.dvs.core.entity

data class ValidatorModel(
    val title: String,
    val avatar: String,
    val description: String,
    val mainNets: List<ValidatorNetwork>,
    val testNets: List<ValidatorNetwork>? = null,
    val genesisNets: List<ValidatorNetwork>? = null,
    val otherProjects: List<OtherProjects>,
    val ambassadorPrograms: List<Project>,
    val contributions: List<Contributions>,
    val contacts: List<Contact>,
    val otherInfo: List<OtherInfo>
) {
    val validatingNetworksCount = mainNets.size + testNets.orEmpty().size + genesisNets.orEmpty().size
    val otherActivities = otherProjects.size + contributions.size

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
}

data class ValidatorNetwork(
    val network: BlockChainNetwork,
    val link: String
)

data class BlockChainNetwork(
    val title: String,
    val image: String
)

data class OtherProjects(
    val topic: String,
    val projects: List<Project>
)

data class Project(
    val title: String,
    val link: String
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
    val type: String, //tg, twitter, keybase, github, website, medium, discord, instagram, email
    val link: String
)

data class OtherInfo(
    val title: String,
    val body: String
)

