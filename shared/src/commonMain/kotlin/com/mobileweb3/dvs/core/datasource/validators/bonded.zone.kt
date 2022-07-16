package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val bonded_zone = ValidatorModel(
    title = "bonded.zone",
    avatar = "https://user-images.githubusercontent.com/38581319/153678113-306bef03-ec56-412a-a86e-64d2aa6a9337.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CHRONIC,
            validatorAddress = "chronicvaloper105rzlcracxe9r32h8flpn4kpw8waqueqfsne7g",
            walletAddress = "chronic105rzlcracxe9r32h8flpn4kpw8waqueqexd8c2"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = emptyList(),
    otherInfo = emptyList()
)