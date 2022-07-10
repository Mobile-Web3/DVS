package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.BlockChainNetwork
import com.mobileweb3.dvs.core.entity.Contact
import com.mobileweb3.dvs.core.entity.Contribution
import com.mobileweb3.dvs.core.entity.Contributions
import com.mobileweb3.dvs.core.entity.OtherInfo
import com.mobileweb3.dvs.core.entity.OtherProjects
import com.mobileweb3.dvs.core.entity.Project
import com.mobileweb3.dvs.core.entity.ValidatorModel
import com.mobileweb3.dvs.core.entity.ValidatorNetwork

val web34ever = ValidatorModel(
    title = "web34ever",
    avatar = "https://user-images.githubusercontent.com/59205554/162392362-21426138-1f93-4563-a7a7-7fba06774134.PNG",
    description = "Who am I?\n" +
            "Passionate experts with over five years of expertise in decentralized technologies. Professional validator and full time enthusiast from 2015 with powerful knowledge and exhaustive experience in crypto industry, successfully participated in more than 50 testnets. Validate many known mainnet networks such as Solana, MinaProtocol, Avalanche, TheGraph, CertiK, Sentinel, XX-network, FreeTON, Microtick, LikeCoin. Ambassador in Moonbeam, FreeTon (Jury in NFT Subgovarnance), Covalent networks, Polygon, Octopus, Sentinel, TheGraph curator. Co-founder of the rapidly developing crypto <a href=\"https://koinsortium.com/\" rel=\"nofollow\">consortium</a>. Feel free to familiarize yourself with the list of projects below to which I contributed my knowledge, skills and invaluable experience:",
    mainNets = listOf(
        ValidatorNetwork(
            network = BlockChainNetwork(
                "Solana",
                ""
            ),
            link = "https://www.validators.app/validators/mainnet/7MTjmteQHhthwwTZhUzsc2dP4NBvGNRqj8jzdqNxHFGE?locale=en&order=&refresh="
        )
    ),
    testNets = emptyList(),
    otherProjects = listOf(
        OtherProjects(
            topic = "Cosmos SDK projects",
            projects = listOf(
                Project(
                    "Cyber.page",
                    link = "https://rebyc.cyber.page/network/bostrom/hero/bostromvaloper15zs0cjct43xs4z4sesxcrynar5mxm82fh73g0j"
                )
            )
        ),
        OtherProjects(
            topic = "Other projects",
            projects = listOf(
                Project(
                    "NeonLabs",
                    link = "https://neon-labs.org/"
                )
            )
        )
    ),
    ambassadorPrograms = listOf(
        Project(
            title = "Covalent",
            link = "https://github.com/Distributed-Validators-Synctems/Self-Identity/blob/main"
        )
    ),
    contributions = listOf(
        Contributions(
            type = "My contribution 3d video works",
            contributions = listOf(
                Contribution(
                    label = "Cosmos Network",
                    link = "https://www.youtube.com/watch?v=cIxdLwKAYYQ&t=6s&ab_channel=PapsanLysenko"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "telegram",
            link = "https://t.me/hekit"
        )
    ),
    otherInfo = listOf(
        OtherInfo(
            title = "Infra",
            body = "Equinix Bare metal\n" +
                    "\n" +
                    "m3.large.x86\n" +
                    "1x AMD EPYC 7502P 32-Core Processor @ 2.5Ghz\n" +
                    "2x 240GB SSD\n" +
                    "2x 3.8TB NVME\n" +
                    "256GB RAM\n" +
                    "2x 25Gbps ;\n" +
                    "\n" +
                    "s3.xlarge 2x Intel(R) Xeon(R) Silver 4214 CPU @ 2.20GHz ;\n" +
                    "2x 960GB SSD ;\n" +
                    "2x 240GB NVME ; 12x 8TB HDD ;\n" +
                    "192GB RAM ;\n" +
                    "2x 10Gbps ;\n" +
                    "\n" +
                    "c3.medium.x86 1x AMD EPYC 7402P 24-Core Processor;\n" +
                    "2x 240GB SSD;\n" +
                    "2x 480GB SSD\n" +
                    "64GB RAM ;\n" +
                    "2x 10Gbps ;\n" +
                    "\n" +
                    "OVH 4x advance-4, 11x advance-5 ; Hetzner 3x AX41-NVME, 2x AX101\n" +
                    "\n" +
                    "More info soon..."
        )
    )
)