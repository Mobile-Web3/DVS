package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val KURASH = ValidatorModel(
    title = "KURASH",
    avatar = "https://user-images.githubusercontent.com/38581319/154812589-5af71295-27c0-45ca-9fea-b43278bed6bd.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.FETCH_AI,
            validatorAddress = "fetchvaloper14q3mtnec6wjyhyfxcjdgqmx3kqk52gwdryt4vz",
            walletAddress = "fetch14q3mtnec6wjyhyfxcjdgqmx3kqk52gwdxq5kl9"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = listOf(
        Contact(
            type = "Telegram",
            link = "https://t.me/AlexeySergeeich"
        ),
        Contact(
            type = "Github",
            link = "https://github.com/kuraassh"
        ),
    ),
    otherInfo = emptyList()
)