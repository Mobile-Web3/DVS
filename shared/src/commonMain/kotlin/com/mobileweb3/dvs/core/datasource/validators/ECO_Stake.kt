package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val ECO_Stake = ValidatorModel(
    title = "ECO Stake",
    avatar = "https://user-images.githubusercontent.com/38581319/168485007-2f644a93-19b9-4ed0-9a2a-e9199cdf9483.PNG",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.AKASH,
            validatorAddress = "akashvaloper1xgnd8aach3vawsl38snpydkng2nv8a4kqgs8hf",
            walletAddress = "akash1xgnd8aach3vawsl38snpydkng2nv8a4k227p8r"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ASSET_MANTLE,
            validatorAddress = "mantlevaloper1fqs7gakxdmujtk0qufdzth5pfyspus3yx394zd",
            walletAddress = "mantle1fqs7gakxdmujtk0qufdzth5pfyspus3yxwppec"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CERBERUS,
            validatorAddress = "cerberusvaloper1tat2cy3f9djtq9z7ly262sqngcarvaktr0w78f",
            walletAddress = "cerberus1tat2cy3f9djtq9z7ly262sqngcarvaktk7yeah"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CHIHUAHUA,
            validatorAddress = "chihuahuavaloper19vwcee000fhazmpt4ultvnnkhfh23ppwxll8zz",
            walletAddress = "chihuahua19vwcee000fhazmpt4ultvnnkhfh23ppw4gl637"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.COMDEX,
            validatorAddress = "comdexvaloper17f70yjkvmvld379904jaddx9h0f74n32pjtmp6",
            walletAddress = "comdex17f70yjkvmvld379904jaddx9h0f74n32j93flm"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CRYPTO_ORG,
            validatorAddress = "crocncl10mfs428fyntu296dgh5fmhvdzrr2stlaekcrp9",
            walletAddress = "cro10mfs428fyntu296dgh5fmhvdzrr2stla6mm2re"
        ),
//        ValidatorNetwork(
//            blockchainNetwork = BlockchainNetwork.DIG,
//            validatorAddress = "digvaloper136avwnuvvy94dqmtnaue2nfvjes8xr37h9rzay",
//            walletAddress = "dig136avwnuvvy94dqmtnaue2nfvjes8xr37gt2c43"
//        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = emptyList(),
    otherInfo = emptyList()
)