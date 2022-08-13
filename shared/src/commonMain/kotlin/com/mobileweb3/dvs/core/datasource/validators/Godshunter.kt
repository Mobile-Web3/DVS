package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.Project
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val Godshunter = ValidatorModel(
    title = "Godshunter",
    avatar = "https://user-images.githubusercontent.com/38581319/140643843-a4986972-3982-49bc-b499-3e6fb8949113.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SOLANA,
            validatorAddress = "FhtTzi7AjoBTY3RWydBaNQNmcQutpJBeiGYmBET4y1bG"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.AGORIC,
            validatorAddress = "agoricvaloper1cjs0sgxz709mvfyzje7tzsflyhcvrpxv04m2dl"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BOSTROM,
            validatorAddress = "bostromvaloper1zaefvwrgk2g45k68a3ngahgq0xky5zgeluu86f",
            walletAddress = "bostrom1zaefvwrgk2g45k68a3ngahgq0xky5zge8xmc22"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.GALAXY,
            validatorAddress = "galaxyvaloper1ray63rxppdh7wdg3symek4xvqkkudh0a92kgmq",
            walletAddress = "galaxy1ray63rxppdh7wdg3symek4xvqkkudh0act9gcv"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = listOf(
        Project(
            title = "Moonbeam/Moonriver"
        ),
        Project(
            title = "Interlay/Kintsugi"
        ),
        Project(
            title = "Zeitgeist"
        ),
        Project(
            title = "FirFly"
        ),
        Project(
            title = "Claystake"
        )
    ),
    contributionsTypes = listOf(
        Contributions(
            type = "Community",
            contributions = listOf(
                Contribution(
                    label = "Moonbeam RU YouTube channel",
                    link = "https://www.youtube.com/channel/UC1t2t8VqWmekToiPdbbytNQ"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "Github",
            link = "https://github.com/godshunter"
        ),
        Contact(
            type = "Telegram",
            link = "https://t.me/godshunter"
        )
    ),
    otherInfo = emptyList()
)