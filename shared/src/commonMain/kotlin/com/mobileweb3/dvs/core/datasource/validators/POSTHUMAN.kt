package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val POSTHUMAN = ValidatorModel(
    title = "POSTHUMAN",
    avatar = "https://user-images.githubusercontent.com/38581319/171294493-bf8b243c-94b5-4492-82bd-a1e9aed93420.png",
    description = "",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SOLANA,
            validatorAddress = "9PViHDmiezXQfeYDveJrcfkXCQVCcsfhpo32cjHUeZVj"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.PERSISTENCE,
            validatorAddress = "persistencevaloper10sc98vt6saux8asexnsp2hgvkgmjmful8w5cuw",
            walletAddress = "persistence10sc98vt6saux8asexnsp2hgvkgmjmfulw2594h"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.VELAS,
            validatorAddress = "9Hj1BdkKHz9rGoDdqy82huZHpcvK2pAzXoBP1BbECqze"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.FETCH_AI,
            validatorAddress = "fetchvaloper1y02hlwucl6csz4z02ksn46gzdkmref927l4mug",
            walletAddress = "fetch1y02hlwucl6csz4z02ksn46gzdkmref92mm2c00"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.COSMOS,
            validatorAddress = "cosmosvaloper157v7tczs40axfgejp2m43kwuzqe0wsy0rv8puv",
            walletAddress = "cosmos157v7tczs40axfgejp2m43kwuzqe0wsy0xcn5sl"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.OSMOSIS,
            validatorAddress = "osmovaloper1e8238v24qccht9mqc2w0r4luq462yxttfpaeam",
            walletAddress = "osmo1e8238v24qccht9mqc2w0r4luq462yxttnk462u"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.JUNO,
            validatorAddress = "junovaloper1e8238v24qccht9mqc2w0r4luq462yxttjzn7qt",
            walletAddress = "juno1e8238v24qccht9mqc2w0r4luq462yxttdl93mj"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.KICHAIN,
            validatorAddress = "kivaloper1g2sr6x8hrtwwsaaqu8p8r7dzdfugdcsal08gq8",
            walletAddress = "ki1g2sr6x8hrtwwsaaqu8p8r7dzdfugdcsatgf4re"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.RIZON,
            validatorAddress = "rizonvaloper1ckcup3mdvztrps2m788lpytxey47fyn9gkqhfw",
            walletAddress = "rizon1ckcup3mdvztrps2m788lpytxey47fyn9mjzkt7"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.LIKECOIN,
            validatorAddress = "likevaloper13shmgwhlhw36sv6yfqz9llpcynu7pkqngh9sqk",
            walletAddress = "like13shmgwhlhw36sv6yfqz9llpcynu7pkqn7cnws9"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.STARNAME,
            validatorAddress = "starvaloper1euslp8c2qadgs6jy6klwv6f332mj426qje6vsn",
            walletAddress = "star1euslp8c2qadgs6jy6klwv6f332mj426qhj7uu6"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.MEDIBLOC,
            validatorAddress = "panaceavaloper190njxj69lmwdwjhhp0fw5kqsxsu6g876hzgp6z",
            walletAddress = "panacea190njxj69lmwdwjhhp0fw5kqsxsu6g876sqgpxu"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BOSTROM,
            validatorAddress = "bostromvaloper1ccvpcq9ffy0qd2ca8nmmpzfamtyjfc9zt56fhc",
            walletAddress = "bostrom1ccvpcq9ffy0qd2ca8nmmpzfamtyjfc9znwak8m"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.SIFCHAIN,
            validatorAddress = "sifvaloper1lkctf0y8stlvshdkhra0lqcafd5hsq9aad35nm",
            walletAddress = "sif1lkctf0y8stlvshdkhra0lqcafd5hsq9a50e7nt"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ODIN,
            validatorAddress = "odinvaloper1wuwhanclwh9ckpe6z6480t3pjjpk7dsj2trk9p",
            walletAddress = "odin1wuwhanclwh9ckpe6z6480t3pjjpk7dsj8khgv4"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.LUM,
            validatorAddress = "lumvaloper1z7ss5slnpjfkceahl323ag9tkf3a6yrs88h4ng",
            walletAddress = "lum1z7ss5slnpjfkceahl323ag9tkf3a6yrscs7xgv"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.GRAVITY_BRIDGE,
            validatorAddress = "gravityvaloper1epfpvqsc34sfserdx8x4t3aszdkar3w684fwr6",
            walletAddress = "gravity1epfpvqsc34sfserdx8x4t3aszdkar3w6k7ssfw"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CHIHUAHUA,
            validatorAddress = "chihuahuavaloper1fm68jvjpk0g7dvdq75czjynyszeaduxt5lc0a8",
            walletAddress = "chihuahua1fm68jvjpk0g7dvdq75czjynyszeaduxt8gcjwm"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.OMNIFLIX,
            validatorAddress = "omniflixvaloper1s3achxs70ysg8pf9xqyytu0m4had60khpuccxl",
            walletAddress = "omniflix1s3achxs70ysg8pf9xqyytu0m4had60khvw2e8h"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CERBERUS,
            validatorAddress = "cerberusvaloper1td92z5qwl39f407gxf6lu2x80enat7t3jfefnf",
            walletAddress = "cerberus1td92z5qwl39f407gxf6lu2x80enat7t38cnwfh"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.ASSET_MANTLE,
            validatorAddress = "mantlevaloper1xrvhlxasg3duvmz82gn5gggpc8wwry7luclvx9",
            walletAddress = "mantle1xrvhlxasg3duvmz82gn5gggpc8wwry7lu8mcas"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.CERBERUS,
            validatorAddress = "crevaloper12yudzhed4cqjpwkv52hwut7a5xn8h7j97gqhaq",
            walletAddress = "cre12yudzhed4cqjpwkv52hwut7a5xn8h7j9uuqcs2"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.EVMOS,
            validatorAddress = "evmosvaloper1jk7umxyky5m5dul46t8nxneavlg7eysjr6lfj7",
            walletAddress = "evmos1jk7umxyky5m5dul46t8nxneavlg7eysjw5senr"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.COMDEX,
            validatorAddress = "comdexvaloper1963hcznh439kspqmjj5hv5h4nk2kphvats5ujk",
            walletAddress = "comdex1963hcznh439kspqmjj5hv5h4nk2kphvac8wwvh"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.UMEE,
            validatorAddress = "umeevaloper1qa5gkv8a4rzpncgkguv2szh5s83kh69l082zz3",
            walletAddress = "umee1qa5gkv8a4rzpncgkguv2szh5s83kh69l0rddnm"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Our Contributions",
            contributions = listOf(
                Contribution(
                    label = "Cosmos Network",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/cosmos.md"
                ),
                Contribution(
                    label = "Osmosis",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/osmosis.md"
                ),
                Contribution(
                    label = "Persistence",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/persistence.md"
                ),
                Contribution(
                    label = "Starname",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/starname.md"
                ),
                Contribution(
                    label = "Fetch.ai",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/fetchAI.md"
                ),
                Contribution(
                    label = "LikeCoin",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/LikeCoin.md"
                ),
                Contribution(
                    label = "Solana",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/solana.md"
                ),
                Contribution(
                    label = "Juno Network",
                    link = "https://github.com/Antropocosmist/My-Contributions/blob/main/juno.md"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "Website",
            link = "https://posthuman.digital/"
        ),
        Contact(
            type = "Github",
            link = "https://github.com/Antropocosmist/my_competencies"
        ),
        Contact(
            type = "Telegram",
            link = "https://t.me/antropocosmist"
        ),
        Contact(
            type = "Twitter",
            link = "https://twitter.com/POSTHUMAN_DVS"
        ),
        Contact(
            type = "Medium",
            link = "https://antropocosmist.medium.com/"
        ),
        Contact(
            type = "Email",
            link = "validator@posthuman.digital"
        )
    ),
    otherInfo = emptyList()
)