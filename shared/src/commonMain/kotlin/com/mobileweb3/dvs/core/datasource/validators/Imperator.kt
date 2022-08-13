package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val Imperator = ValidatorModel(
    title = "Imperator",
    avatar = "https://user-images.githubusercontent.com/38581319/128100575-837809fe-2bf9-44ab-9e1b-fbc911b7cf45.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.KICHAIN,
            validatorAddress = "kivaloper1zjmeu3nv6s90sa00ljdz4hswf7qs6f9rpjutgv",
            walletAddress = "ki1zjmeu3nv6s90sa00ljdz4hswf7qs6f9r44jktj"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITSONG,
            validatorAddress = "bitsongvaloper1stxt50ygdlfwu7erkyps3j4wfq6vx935ry53ne",
            walletAddress = "bitsong1stxt50ygdlfwu7erkyps3j4wfq6vx935zqgcry"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.PERSISTENCE,
            validatorAddress = "persistencevaloper1ydtka79nhg62v36lgre6vlfjauvlelau9rvgwh",
            walletAddress = "persistence1ydtka79nhg62v36lgre6vlfjauvlelauv8v48w"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.OSMOSIS,
            validatorAddress = "osmovaloper1t8qckan2yrygq7kl9apwhzfalwzgc2429p8f0s",
            walletAddress = "osmo1t8qckan2yrygq7kl9apwhzfalwzgc242lk02ch"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.AKASH,
            validatorAddress = "akashvaloper1enhj36w6clcm5fjnp87jnffnkthfux2uj88l6h",
            walletAddress = "akash1enhj36w6clcm5fjnp87jnffnkthfux2uc9fe2a"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Activities",
            contributions = listOf(
                Contribution(
                    label = "Osmosis Dashboard",
                    link = "https://osmosis.imperator.co/"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "Website",
            link = "https://imperator.co/"
        )
    ),
    otherInfo = emptyList()
)