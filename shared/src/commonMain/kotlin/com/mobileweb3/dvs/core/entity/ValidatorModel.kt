package com.mobileweb3.dvs.core.entity

data class ValidatorModel(
    val title: String,
    val avatar: String,
    val description: String,
    val mainNets: List<ValidatorNetwork>,
    val testNets: List<ValidatorNetwork>? = null,
    val otherProjects: List<OtherProjects>,
    val ambassadorPrograms: List<Project>,
    val contributions: List<Contributions>,
    val contacts: List<Contact>,
    val otherInfo: List<OtherInfo>
)

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

