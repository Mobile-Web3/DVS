package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val DomaNodes = ValidatorModel(
    title = "DomaNodes",
    avatar = "https://user-images.githubusercontent.com/38581319/140642783-1205824f-33ca-4f99-844b-805558ef15fd.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SIFCHAIN,
            validatorAddress = "sifvaloper1egdnktas7ewzudyn2t4hxd2l2awsahkz7za26z",
            walletAddress = "sif1egdnktas7ewzudyn2t4hxd2l2awsahkzhq4q6j"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.JUNO,
            validatorAddress = "junovaloper1eslgmvrdyfr7rzkur93q7u6wnknv56lrwsht0c",
            walletAddress = "juno1eslgmvrdyfr7rzkur93q7u6wnknv56lr3dpy5p"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Community",
            contributions = listOf(
                Contribution(
                    label = "Alephium",
                    link = "https://medium.com/@alephium/time-for-an-alephium-development-recap-cdaa47ee95a"
                )
            )
        ),
        Contributions(
            type = "Hackatons",
            contributions = listOf(
                Contribution(
                    label = "NearProtocol",
                    link = "https://twitter.com/zavodil_ru/status/1474128194815107075"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "github",
            link = "https://github.com/doma2k"
        ),
        Contact(
            type = "telegram",
            link = "https://t.me/domanodes"
        )
    ),
    otherInfo = emptyList()
)