package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val anvi79 = ValidatorModel(
    title = "👋 79anvi 🍀",
    avatar = "https://user-images.githubusercontent.com/38581319/148276970-9142c5b1-4621-4355-b1bb-df36e8393769.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.GRAVITY_BRIDGE,
            validatorAddress = "gravityvaloper18u9pws4989n7fmx5pduev7starj8wqgg4jcxr3",
            walletAddress = "gravity18u9pws4989n7fmx5pduev7starj8wqggyepcf9"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.KICHAIN,
            validatorAddress = "kivaloper1mfr64h8rmnlg2g90m6qk3zw80vgxmuumq0ng9x",
            walletAddress = "ki1mfr64h8rmnlg2g90m6qk3zw80vgxmuum5ga4xc"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.RIZON,
            validatorAddress = "rizonvaloper1gke47wnpdnqqspju5xe5448gxmz36vt8fksjmc",
            walletAddress = "rizon1gke47wnpdnqqspju5xe5448gxmz36vt86jjneg"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.IXO,
            validatorAddress = "ixovaloper1680a2sy8z63cxczjl34xpzusv4es7yrn6y4f5x",
            walletAddress = "ixo1680a2sy8z63cxczjl34xpzusv4es7yrns99cvr"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CHIHUAHUA,
            validatorAddress = "chihuahuavaloper1nh26fjk060g4umun5czgdkprws4qmzaxmeqmlc",
            walletAddress = "chihuahua1nh26fjk060g4umun5czgdkprws4qmzaxgwqxvy"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ASSET_MANTLE,
            validatorAddress = "mantlevaloper1ppvfpcp7grhgpkvse4rk877ysuztg73r04y68z",
            walletAddress = "mantle1ppvfpcp7grhgpkvse4rk877ysuztg73r02qwuh"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = listOf(
        Contact(
            type = "github",
            link = "https://github.com/79anvi"
        ),
        Contact(
            type = "telegram",
            link = "https://t.me/Andrei2cards"
        ),
        Contact(
            type = "website",
            link = "https://79anvi.com/"
        )
    ),
    otherInfo = emptyList()
)