package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val OpenTechStaking = ValidatorModel(
    title = "OpenTech Staking",
    avatar = "https://user-images.githubusercontent.com/38581319/121074384-10931180-c7d4-11eb-8c61-1787630e866c.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.STARNAME,
            validatorAddress = "starvaloper1gvt5u6ggvtcas4l7ez4lyvgusqdefckxqlj7lk",
            walletAddress = "star1gvt5u6ggvtcas4l7ez4lyvgusqdefckx95kwnl"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.MEDIBLOC,
            validatorAddress = "panaceavaloper1kqz8nfz2cltecc3muwq9lgcqgps2lghurwj9zp",
            walletAddress = "panacea1kqz8nfz2cltecc3muwq9lgcqgps2lghuyvj97l"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.VELAS,
            validatorAddress = "DVS9CpX27eadivLYMNWkmiV8bwq7hGZQf6a3g7hkHvGV"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = listOf(
        Contact(
            type = "website",
            link = "https://validators.network/"
        )
    ),
    otherInfo = emptyList()
)