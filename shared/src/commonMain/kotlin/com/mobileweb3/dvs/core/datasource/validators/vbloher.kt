package com.mobileweb3.dvs.core.datasource.validators
import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val vbloher = ValidatorModel(
    title = "vbloher",
    avatar = "https://user-images.githubusercontent.com/38581319/137599261-a856d69e-4133-46ec-b821-5c729fa07b6b.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ASSET_MANTLE,
            validatorAddress = "mantlevaloper12w4wch0vykgw6qyveurhqck75n3dnw0c0c4fje",
            walletAddress = "mantle12w4wch0vykgw6qyveurhqck75n3dnw0c083afv"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SIFCHAIN,
            validatorAddress = "sifvaloper1tvy5apxqsf3jf0uhzknvj6qndy473smzjezvh9",
            walletAddress = "sif1tvy5apxqsf3jf0uhzknvj6qndy473smzmm2xh4"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.RIZON,
            validatorAddress = "rizonvaloper1h7qgg8p52vdpcqzhxrt6wjsnyyfasaak588lrh",
            walletAddress = "rizon1h7qgg8p52vdpcqzhxrt6wjsnyyfasaak8r97p8"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.KICHAIN,
            validatorAddress = "kivaloper1ggrrt80qln07kqnfe5zppjgsrrqmkc4jpwvsgh",
            walletAddress = "ki1ggrrt80qln07kqnfe5zppjgsrrqmkc4j4fzdtf"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITCANNA,
            validatorAddress = "bcnavaloper19l7slf3853c9ul0vf24zefjvdq4l8930nulqp4",
            walletAddress = "bcna19l7slf3853c9ul0vf24zefjvdq4l89302pwqmp"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Technical",
            contributions = listOf(
                Contribution(
                    label = "Easy to use monitoring stack",
                    link = "https://github.com/vbloher/monitoring-tool"
                )
            )
        ),
        Contributions(
            type = "Video",
            contributions = listOf(
                Contribution(
                    label = "How to set up monitoring for Kujira",
                    link = "https://www.youtube.com/watch?v=rWDLdVRx_Bs"
                )
            )
        ),
        Contributions(
            type = "Guides",
            contributions = listOf(
                Contribution(
                    label = "How to bootstrap any tendermint (cosmos) node using State-Sync",
                    link = "https://teletype.in/@vbloher/state-sync-bootstrap"
                ),
                Contribution(
                    label = "How to set up a Tendermint node for work as a State-Sync RPC server",
                    link = "https://teletype.in/@vbloher/state-sync-rpc"
                ),
                Contribution(
                    label = "Sifchain Validator Monitoring with Grafana & Prometheus",
                    link = "https://medium.com/@vbloher/sifchain-validator-monitoring-with-grafana-prometheus-967f3c65f9cf"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "Website",
            link = "https://vbloher.com/"
        ),
        Contact(
            type = "Telegram",
            link = "https://t.me/vbloher"
        ),
        Contact(
            type = "Github",
            link = "https://github.com/vbloher"
        ),
        Contact(
            type = "Keybase",
            link = "https://keybase.io/vbloher"
        )
    ),
    otherInfo = emptyList()
)