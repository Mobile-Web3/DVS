package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.Contribution
import com.mobileweb3.dvs.core.entity.validator.Contributions
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val ParanormalBrothers = ValidatorModel(
    title = "Paranormal Brothers",
    avatar = "https://user-images.githubusercontent.com/93286644/177212414-c3de5505-afee-47c8-b81f-63570dd66e5d.png",
    description = "Alumnus of Validator school\nMentor with Validator packaging lesson in Validators school",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.BITCANNA,
            validatorAddress = "bcnavaloper14h2x997gt54v7akrxdfakd33x9yxa5kh9t0r9a",
            walletAddress = "bcna14h2x997gt54v7akrxdfakd33x9yxa5khuk7rlf"
        ),
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.COMDEX,
            validatorAddress = "comdexvaloper1czs368jkxgwflufajtvr0lhg6660aeplz9s5qn",
            walletAddress = "comdex1czs368jkxgwflufajtvr0lhg6660aepl3j2x7j"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = listOf(
        Contributions(
            type = "Art",
            contributions = listOf(
                Contribution(
                    label = "3D visualisations for Massa",
                    link = "https://disk.yandex.ru/d/lKKkX07m_wz5ug"
                ),
                Contribution(
                    label = "Memes",
                    link = "https://disk.yandex.ru/d/UX0K7PycWHOQBw"
                )
            )
        ),
        Contributions(
            type = "Technical",
            contributions = listOf(
                Contribution(
                    label = "Massa Testnet node dashboard",
                    link = "https://paranormal-brothers.com/massa/"
                ),
                Contribution(
                    label = "Telegram FAQ bot",
                    link = "https://t.me/paramassa_bot"
                ),
                Contribution(
                    label = "Monitoring system for Comdex blockchain",
                    link = "https://comdex.paranorm.pro/"
                )
            )
        ),
        Contributions(
            type = "Community",
            contributions = listOf(
                Contribution(
                    label = "Running node and in leaderboard"
                ),
                Contribution(
                    label = "Active member of Telegram and Discord groups"
                ),
                Contribution(
                    label = "Deploy Massa guide",
                    link = "https://github.com/ParanormalBrothers/Massa-Node-Docker"
                )
            )
        )
    ),
    contacts = listOf(
        Contact(
            type = "github",
            link = "https://github.com/ParanormalBrothers"
        ),
        Contact(
            type = "telegram",
            link = "https://t.me/nordhedgehog"
        ),
        Contact(
            type = "website",
            link = "https://paranormal-brothers.com/"
        )
    )
)