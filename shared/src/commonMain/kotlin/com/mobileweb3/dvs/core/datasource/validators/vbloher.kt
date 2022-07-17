package com.mobileweb3.dvs.core.datasource.validators
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val vbloher = ValidatorModel(
    title = "vbloher",
    avatar = "https://user-images.githubusercontent.com/38581319/137599261-a856d69e-4133-46ec-b821-5c729fa07b6b.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ASSET_MANTLE,
            validatorAddress = "mantlevaloper12w4wch0vykgw6qyveurhqck75n3dnw0c0c4fje",
            walletAddress = "mantle12w4wch0vykgw6qyveurhqck75n3dnw0c083afv"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = emptyList(),
    otherInfo = emptyList()
)