package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val BananaMaker = ValidatorModel(
    title = "BananaMaker",
    avatar = "https://user-images.githubusercontent.com/38581319/151626346-78f2dbe5-9c96-4590-8dab-76d31dcc1177.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.MEDIBLOC,
            validatorAddress = "panaceavaloper1h7glzr6dn4hz0fethj59870gv8v8aqm87sz2k8",
            walletAddress = "panacea1h7glzr6dn4hz0fethj59870gv8v8aqm8ejz22e"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = listOf(
        Contact(
            type = "Github",
            link = "https://github.com/Stalisnav"
        ),
        Contact(
            type = "Telegram",
            link = "https://t.me/Filantro"
        ),
        Contact(
            type = "Website",
            link = "https://bananamaker.net/"
        )
    ),
    otherInfo = emptyList()
)