package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.Project
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val cyberG = ValidatorModel(
    title = "cyberG",
    avatar = "https://user-images.githubusercontent.com/38581319/162858452-c6127040-eab3-4dee-96c6-8ead3cd4636d.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.AVALANCHE,
            validatorAddress = "NodeID-Jm1k2q2WAkH99w4ZBEgzrmm6Kte39qCWJ"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITSONG,
            validatorAddress = "bitsongvaloper1mx3gct8chrssamkdfw8fkrdl93knllryalmxpm",
            walletAddress = "bitsong1mx3gct8chrssamkdfw8fkrdl93knllryum803x"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BOSTROM,
            validatorAddress = "bostromvaloper1en69twaxmv7xupy8lq7y539dpecx7yz8s43ceg",
            walletAddress = "bostrom1en69twaxmv7xupy8lq7y539dpecx7yz8g0k8ft"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CERTIK,
            validatorAddress = "certikvaloper1yq8a2ksa7dz8wd8wlks3k8nqdmht76xdnrvehx",
            walletAddress = "certik1yq8a2ksa7dz8wd8wlks3k8nqdmht76xdyhge7u"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.COMDEX,
            validatorAddress = "comdexvaloper1963hcznh439kspqmjj5hv5h4nk2kphvats5ujk",
            walletAddress = "comdex1963hcznh439kspqmjj5hv5h4nk2kphvac8wwvh"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CHRONIC,
            validatorAddress = "chronicvaloper1x8czjpdy2x9svz0s3u9hdgqxd06ta39y49lnd3",
            walletAddress = "chronic1x8czjpdy2x9svz0s3u9hdgqxd06ta39y9npdtn"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.GRAVITY_BRIDGE,
            validatorAddress = "gravityvaloper1yeujyxulrf82age8c9q6mfqy0ueh0pjxa7hd20",
            walletAddress = "gravity1yeujyxulrf82age8c9q6mfqy0ueh0pjxv4wnqm"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.GALAXY,
            validatorAddress = "galaxyvaloper1f8tm4wspt687qg36c6rrrv8enuwhr5crsuqfjx",
            walletAddress = "galaxy1f8tm4wspt687qg36c6rrrv8enuwhr5crdanf32"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.JUNO,
            validatorAddress = "junovaloper1353ewfc0v7pnn3xre6v9lraghxrhenswmsjhv0",
            walletAddress = "juno1353ewfc0v7pnn3xre6v9lraghxrhenswydychk"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.KUJIRA,
            validatorAddress = "kujiravaloper1tharcgrfu6j0dcwpe5y6ez3s904rhq2kmccm4k",
            walletAddress = "kujira1tharcgrfu6j0dcwpe5y6ez3s904rhq2kudtgfe"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.MINA,
            validatorAddress = "B62qrgnUUduZy2z7zT8qCV8ngTJfSS1rK3Wh22SHUmrse3Tfqvrhx8q"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.OMNIFLIX,
            validatorAddress = "omniflixvaloper1dfjx8w65h359vy55dvm383ks2xevsne9crkh32",
            walletAddress = "omniflix1dfjx8w65h359vy55dvm383ks2xevsne943yksz"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.RIZON,
            validatorAddress = "rizonvaloper1swmud649t386j2csz0gah7ku2zpfu0w7trzr09",
            walletAddress = "rizon1swmud649t386j2csz0gah7ku2zpfu0w7c8qzd4"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SOLANA,
            validatorAddress = "GmZ7xFQ4GHDbQw4CSnFT9pAHa15u35qTN8e259UrBh9D"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.STARGAZE,
            validatorAddress = "starsvaloper1dtk6748uhvmhvakhleclrwprp27pe89vhhw44p",
            walletAddress = "stars1dtk6748uhvmhvakhleclrwprp27pe89vuf6pwe"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.UMEE,
            validatorAddress = "umeevaloper1qa5gkv8a4rzpncgkguv2szh5s83kh69l082zz3",
            walletAddress = "umee1qa5gkv8a4rzpncgkguv2szh5s83kh69l0rddnm"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.VELAS,
            validatorAddress = "7MYojjTNnFsyEs7Pb5Xv3pKeZxUGk6R1kJoLrtSKkSRy"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.XX_NETWORK,
            validatorAddress = "2C5ngNbgU_r2bUrvzvAGJddGOhNboOt2r5ZSmJ-GezgC"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = listOf(
        Project(
            title = "Clipper"
        ),
        Project(
            title = "Covalent"
        ),
        Project(
            title = "Cyber"
        ),
        Project(
            title = "Hacken"
        ),
        Project(
            title = "Moonbeam"
        ),
        Project(
            title = "Polygon"
        ),
        Project(
            title = "TheGraph"
        )
    ),
    contributionsTypes = listOf(
        Contributions(
            type = "Past campaigns",
            contributions = listOf(
                Contribution(
                    label = "dClimate",
                ),
                Contribution(
                    label = "FreeTON",
                ),
                Contribution(
                    label = "Goldfinch",
                ),
                Contribution(
                    label = "Biconomy",
                ),
                Contribution(
                    label = "Persistence",
                ),
                Contribution(
                    label = "Secret Network",
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "website",
            link = "https://www.cyberg.digital/"
        ),
        Contact(
            type = "twitter",
            link = "https://twitter.com/vadyhodler777"
        ),
        Contact(
            type = "telegram",
            link = "https://t.me/cryptoq11"
        ),
        Contact(
            type = "medium",
            link = "https://88vgk88.medium.com/"
        ),
        Contact(
            type = "instagram",
            link = "https://www.instagram.com/vadim.k88/"
        ),
        Contact(
            type = "keybase",
            link = "https://keybase.io/vgk8888"
        )
    ),
    otherInfo = emptyList()
)