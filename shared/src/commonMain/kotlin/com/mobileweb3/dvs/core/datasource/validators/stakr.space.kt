package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.Project
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val stakrspace = ValidatorModel(
    title = "stakr.space",
    avatar = "https://user-images.githubusercontent.com/38581319/123712181-1b404400-d872-11eb-9213-9cde86c03d73.PNG",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SOLANA,
            validatorAddress = "E9hD3ikumJx1GVswDjnpCt6Uu4WG5mz1PDWCqdE5uhmo"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.VELAS,
            validatorAddress = "He8EzKJ7dmp37oecC7NnSGSicXdRubjjovd9xWR9UPYH"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.OMNIFLIX,
            validatorAddress = "omniflixvaloper1vcjmshcst9zjh4pydsvqdssg86nzheykssjh5m",
            walletAddress = "omniflix1vcjmshcst9zjh4pydsvqdssg86nzheykazqk4n"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ASSET_MANTLE,
            validatorAddress = "mantlevaloper1z79zeeyvdgqddevdng3u8d3kqt87dtq3jhsqvq",
            walletAddress = "mantle1z79zeeyvdgqddevdng3u8d3kqt87dtq3jg55h4"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.GALAXY,
            validatorAddress = "galaxyvaloper1wuem8vc5tmlm3m7gaqt00qn37dxe9vkuzqsn4j",
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = listOf(
        Project(
            title = "Moonbeam",
            link = "https://moonbeam.network/community/ambassadors/"
        )
    ),
    contributionsTypes = listOf(
        Contributions(
            type = "Activities",
            contributions = listOf(
                Contribution(
                    label = "Umee Translations",
                    link = "https://synctems.medium.com/umee-faq-ru-4948f53ca423"
                ),
                Contribution(
                    label = "Akash guides, essays",
                    link = "https://github.com/papanomad535/blog/blob/main/akash-deployment/deployments-and-persistent-storage.md"
                ),
                Contribution(
                    label = "Klever guides, monitoring",
                    link = "https://github.com/papanomad535/blog/tree/main/klever-testnet"
                ),
                Contribution(
                    label = "DVS multisig web ui signer",
                    link = "https://cosmos-multisig-6gcn2a7ce-dvs-app.vercel.app/"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "Website",
            link = "https://stakr.space/#contact"
        ),
        Contact(
            type = "Github",
            link = "https://github.com/papanomad535/blog"
        )
    ),
    otherInfo = emptyList()
)