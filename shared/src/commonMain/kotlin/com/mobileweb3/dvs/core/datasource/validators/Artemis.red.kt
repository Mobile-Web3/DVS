package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val Artemis_red = ValidatorModel(
    title = "Artemis.red",
    avatar = "https://user-images.githubusercontent.com/38581319/166976374-e8aa7581-df5a-4fed-bb7e-3d170bd4af6c.png",
    description = "More nets going soon...",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SECRET,
            validatorAddress = "secretvaloper1jjlfeshltdy6ngnf5tg6aeaygsvf0kxg8wck04",
            walletAddress = "secret1jjlfeshltdy6ngnf5tg6aeaygsvf0kxgkfktzu"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = listOf(
        Contact(
            type = "Github",
            link = "https://github.com/Artemisred"
        ),
        Contact(
            type = "Telegram",
            link = "https://t.me/Art3misred"
        )
    ),
    otherInfo = emptyList()
)