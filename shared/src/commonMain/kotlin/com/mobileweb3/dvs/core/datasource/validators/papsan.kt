package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val papsan = ValidatorModel(
    title = "papsan",
    avatar = "https://user-images.githubusercontent.com/38581319/127261101-7d098553-21fc-44d1-9667-adcd7ac08d51.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SOLANA,
            validatorAddress = "syrs1ewkLaWrJ3VoXhFtZHZZSRNTRb6qQhkEhmXKbcC"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BOSTROM,
            validatorAddress = "bostromvaloper18naxcfp2s397a2ucav2m53f003uylk3q6lwnna",
            walletAddress = "bostrom18naxcfp2s397a2ucav2m53f003uylk3qz9fvr7"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITSONG,
            validatorAddress = "bitsongvaloper12gt92p97xhwd8xsp0f54nadzc7r2utakvverr8",
            walletAddress = "bitsong12gt92p97xhwd8xsp0f54nadzc7r2utakdg92n6"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.STARGAZE,
            validatorAddress = "starsvaloper14ftwwcfvhnp3qvxawesjan5duh8rmrkrzdvquy",
            walletAddress = "stars14ftwwcfvhnp3qvxawesjan5duh8rmrkrfnc58u"
        )
    ),
    testNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BOSTROM,
            validatorAddress = "bostromvaloper18naxcfp2s397a2ucav2m53f003uylk3q6lwnna",
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SOLANA,
            validatorAddress = "D6beCFAZeFtXoZKio6JZV1GUmJ99Nz4XhtxMePFvuJWN",
        )
    ),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Activities",
            contributions = listOf(
                Contribution(
                    label = "FreeTON contest winner #1",
                    link = "https://gov.freeton.org/submission?proposalAddress=0%3Adc39814b06b04bf7763dc01716f1ff0e6361d1a9dd79c79314c5e30c701da38e&submissionId=26"
                ),
                Contribution(
                    label = "FreeTON contest winner #2",
                    link = "https://gov.freeton.org/submission?proposalAddress=0%3Ac26da8b9e2628d909c389a1d6bbf7024d3ad8a0a31cd85ee13ce35f07dff388e&submissionId=33"
                ),
                Contribution(
                    label = "FreeTON contest winner #2",
                    link = "https://wd.gov.freeton.org/submission?proposalAddress=0%3A4d1bd7f494bb23c63c10142f32fee89bf87b1db74e49717253e2adc07f3de880&submissionId=41"
                )
            )
        )
    ),
    contacts = emptyList(),
    otherInfo = emptyList()
)