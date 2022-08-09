package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val moonsoon = ValidatorModel(
    title = "moonsoon",
    avatar = "https://user-images.githubusercontent.com/38581319/132548285-3d8d07a7-dfd5-4458-94ca-8a3c1de2bdba.PNG",
    description = "more info will be added soon...",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITSONG,
            validatorAddress = "bitsongvaloper1nw4wmjq7le0h993tn27kmnqk2y8mdvhutzklgk",
            walletAddress = "bitsong1nw4wmjq7le0h993tn27kmnqk2y8mdvhu2x2kct"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.STARGAZE,
            validatorAddress = "starsvaloper1y0k86wx0jpfqs9qcq6alalfwvyackwfqkeqdwh",
            walletAddress = "stars1y0k86wx0jpfqs9qcq6alalfwvyackwfqa85e40"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = listOf(
        Contact(
            type = "github",
            link = "https://github.com/tt1000vv"
        )
    ),
    otherInfo = emptyList()
)