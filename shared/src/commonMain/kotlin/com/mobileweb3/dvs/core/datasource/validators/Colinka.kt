package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.Project
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val Colinka = ValidatorModel(
    title = "Colinka",
    avatar = "https://user-images.githubusercontent.com/38581319/127103374-84ef15b3-0999-4073-bd53-2a8cd31a19f3.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SOLANA,
            validatorAddress = "8QLfmTYxnws98ogFfxdpvRSfSR7U9HLcighZHNfFNQwT"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.IDENA,
            validatorAddress = "0x70aa61e47d11231b4d38fd1e83312854e5a5b15a"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.VELAS,
            validatorAddress = "96isFFVKbaEsdMgHnBGwaifSiuxF2DjnPMGURbHyrHrC"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.AGORIC,
            validatorAddress = "agoricvaloper1llcs6xwp6gdv4t2krmyupfjjr0xyuwk9npyhzs"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ASSET_MANTLE,
            validatorAddress = "mantlevaloper1907n5d2xwy3av597y6347dsc2ktpl2d9uskpsf",
            walletAddress = "mantle1907n5d2xwy3av597y6347dsc2ktpl2d9u0j4tu"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.GALAXY,
            validatorAddress = "galaxyvaloper1h9n94zezpupvejarv0yfm5783xfpzuvzu4da72",
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = listOf(
        Project(
            title = "Moonbeam"
        ),
        Project(
            title = "Flux"
        ),
        Project(
            title = "Solana"
        )
    ),
    contributionsTypes = listOf(
        Contributions(
            type = "Activities",
            contributions = listOf(
                Contribution(
                    label = "MantaNetwork - Regional Commander"
                ),
                Contribution(
                    label = "Covalent - Alchemist"
                ),
                Contribution(
                    label = "Secret Network - Secret Agent"
                ),
                Contribution(
                    label = "Mina Protocol - GFM member"
                )
            )
        )
    ),
    contacts = emptyList(),
    otherInfo = emptyList()
)