package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val bonded_zone = ValidatorModel(
    title = "bonded.zone",
    avatar = "https://user-images.githubusercontent.com/38581319/153678113-306bef03-ec56-412a-a86e-64d2aa6a9337.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITCANNA,
            validatorAddress = "bcnavaloper1yyps9aer7ldm8tjayft68q8ay5l4nch0waf4yh",
            walletAddress = "bcna1yyps9aer7ldm8tjayft68q8ay5l4nch0hqc47r"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITSONG,
            validatorAddress = "bitsongvaloper1pkepjd307346zadmlxpvs9wqrghkx735v0ehge",
            walletAddress = "bitsong1pkepjd307346zadmlxpvs9wqrghkx735dt97cy"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CHRONIC,
            validatorAddress = "chronicvaloper105rzlcracxe9r32h8flpn4kpw8waqueqfsne7g",
            walletAddress = "chronic105rzlcracxe9r32h8flpn4kpw8waqueqexd8c2"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.DESMOS,
            validatorAddress = "desmosvaloper13has6wzwyfyuq6r9j48cwugl6ajqw44gv0fa6k",
            walletAddress = "desmos13has6wzwyfyuq6r9j48cwugl6ajqw44gjzpfsy"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.RIZON,
            validatorAddress = "rizonvaloper1jnjg9fl5hflwgjyu9vrht3j52nn68yjesxaqmr",
            walletAddress = "rizon1jnjg9fl5hflwgjyu9vrht3j52nn68yjerzlpen"
        )
    ),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Technical",
            contributions = listOf(
                Contribution(
                    label = "State-Sync service",
                    link = "https://sync.bonded.zone/"
                ),
                Contribution(
                    label = "Guide - How to setup Klever validator",
                    link = "https://bondedzone.medium.com/how-to-setup-klever-validator-ff58b502e64d"
                ),
                Contribution(
                    label = "Guide - Configure State-Sync for the Rizon mainnet",
                    link = "https://bondedzone.medium.com/configure-state-sync-for-the-rizon-mainnet-9e1fd8c05d1f"
                )
            )
        ),
        Contributions(
            type = "Group admin",
            contributions = listOf(
                Contribution(
                    label = "Rizon ru",
                    link = "https://t.me/rizon_atolo_ru"
                ),
                Contribution(
                    label = "Транслятор Экосистемы Космос",
                    link = "https://t.me/CosmosEcosystemNews_ru"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "Website",
            link = "https://bonded.zone/"
        ),
        Contact(
            type = "Medium",
            link = "https://bondedzone.medium.com/"
        ),
        Contact(
            type = "Twitter",
            link = "https://twitter.com/SKosjakoff"
        ),
        Contact(
            type = "Telegram",
            link = "https://t.me/kosjakoff"
        ),
        Contact(
            type = "Discord",
            link = "https://discord.com/users/864778911548309506"
        ),
        Contact(
            type = "Keybase",
            link = "https://keybase.io/kosjakoff"
        )
    ),
    otherInfo = emptyList()
)