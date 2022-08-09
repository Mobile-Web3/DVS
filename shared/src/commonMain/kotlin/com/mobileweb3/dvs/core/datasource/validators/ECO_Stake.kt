package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.OtherInfo
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val ECO_Stake = ValidatorModel(
    title = "ECO Stake",
    avatar = "https://user-images.githubusercontent.com/38581319/168485007-2f644a93-19b9-4ed0-9a2a-e9199cdf9483.PNG",
    description = "Core contributor for <a href=\"https://github.com/ovrclk/cosmos-omnibus\">Cosmos Omnibus</a> - run Cosmos nodes in containers/on Akash\n" +
            "Created <a href=\"https://restake.app/\">REStake.app</a> - allows validators to autocompound your staking rewards\n" +
            "Created <a href=\"https://cosmos.directory/\">cosmos.directory</a> - interchain 'hub' and APIs for the Cosmos ecosystem",
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
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.DIG,
            validatorAddress = "digvaloper136avwnuvvy94dqmtnaue2nfvjes8xr37h9rzay",
            walletAddress = "dig136avwnuvvy94dqmtnaue2nfvjes8xr37gt2c43"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.OSMOSIS,
            validatorAddress = "osmovaloper1u5v0m74mql5nzfx2yh43s2tke4mvzghr6m2n5t",
            walletAddress = "osmo1u5v0m74mql5nzfx2yh43s2tke4mvzghrqvzsrv"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.REGEN,
            validatorAddress = "regenvaloper1c4y3j05qx652rnxm5mg4yesqdkmhz2f6dl7hhk",
            walletAddress = "regen1c4y3j05qx652rnxm5mg4yesqdkmhz2f63crj08"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SIFCHAIN,
            validatorAddress = "sifvaloper19t5nk5ceq5ga75epwdqhnupwg0v9339p096ydz",
            walletAddress = "sif19t5nk5ceq5ga75epwdqhnupwg0v9339px8jwdj"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Contributions",
            contributions = listOf(
                Contribution(
                    label = "Cosmos Omnibus",
                    link = "https://github.com/ovrclk/cosmos-omnibus"
                ),
                Contribution(
                    label = "REStake.app",
                    link = "https://restake.app/"
                ),
                Contribution(
                    label = "cosmos.directory",
                    link = "https://cosmos.directory/"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "website",
            link = "https://www.ecostake.com/"
        ),
        Contact(
            type = "discord",
            link = "https://discord.gg/MuB7qfBncg"
        ),
        Contact(
            type = "github",
            link = "https://github.com/eco-stake"
        )
    ),
    otherInfo = listOf(
        OtherInfo(
            title = "Akash CAB (Community Awards Board) member, reviewing and approving grants for the Akash Community fund",
            body = ""
        )
    )
)