package com.mobileweb3.dvs.core.datasource.validators

import com.mobileweb3.dvs.core.entity.validator.BlockchainNetwork
import com.mobileweb3.dvs.core.entity.validator.Contact
import com.mobileweb3.dvs.core.entity.validator.OtherInfo
import com.mobileweb3.dvs.core.entity.validator.ValidatorModel
import com.mobileweb3.dvs.core.entity.validator.ValidatorNetwork

val Quantum_AI = ValidatorModel(
    title = "Quantum_AI",
    avatar = "https://user-images.githubusercontent.com/38581319/151630985-483a7fa9-279d-4d7d-928e-f6be1c329ad6.png",
    description = "Machine learning and Physics Researcher, PhD on Theoretical Physics. Member of the LHCb collaboration. Cypherpunk. Validation proceeds support my research.",
    mainNets = listOf(
        ValidatorNetwork(
            blockchainNetwork = BlockchainNetwork.RIZON,
            validatorAddress = "rizonvaloper15xl0rsxunv9nvqvcec28hx0mmtctc6l04tl7m0",
            walletAddress = "rizon15xl0rsxunv9nvqvcec28hx0mmtctc6l0x0alel"
        )
    ),
    testNets = emptyList(),
    otherProjects = emptyList(),
    ambassadorPrograms = emptyList(),
    contributionsTypes = emptyList(),
    contacts = listOf(
        Contact(
            type = "github",
            link = "https://github.com/Widlar/"
        ),
        Contact(
            type = "telegram",
            link = "https://t.me/sm_quantum"
        ),
        Contact(
            type = "keybase",
            link = "https://keybase.io/quantum_ai"
        )
    ),
    otherInfo = listOf(
        OtherInfo(
            title = "OpenPGP Fingerprint:",
            body = "2716 D5AD B088 F50F 6AC2  9D43 5251 6098 26CD BFE3"
        ),
        OtherInfo(
            title = "OpenPGP Key (Valid until 05.12.2023 12:00)",
            body = "-----BEGIN PGP PUBLIC KEY BLOCK-----\n" +
                    "\n" +
                    "mQGNBGGsAMEBDADKA/4HS/16LM4SWHQdRQK1TuKh2UGqJPwiA7WWojNAX5WXJiK4\n" +
                    "31Clt6wMSYaGDx9EfoiY1QIBUPlpAkWk/PaCUxL1pFZDncuBuBhuOrBA0uiFSDZc\n" +
                    "WMKm06NPC3hTAzDcbarnEwiS+nn0nsy+H8MxGAm4m902RiVDSIC7C10CRThNuTy1\n" +
                    "avaE6Br758UDxnbYaVSAj9LQPdshkusBnYju9Epxws15UgX5+MZZFqI8LMsJNZSK\n" +
                    "sdGw3HX8jCKvKu5Arcc5iGZ/NfqVibztFQ27BR5Tbq9NQnghAldYY8A4gNOB9K1E\n" +
                    "/LIQQcOO2aSsda+TqJLqaT3d0ZDRd6pL+yvuPNg7rSYS0rGg45j3Rwh3ijj8GFKV\n" +
                    "1kRDEyKawzBewKwiai2T0RPHixVJDZan3pcKn8RsdNDRcIew+64a3kcftCK8qeQW\n" +
                    "LfT2lLoDiZJHEojketzPi3krbVym75jdrwv1u2rhQ0497TzvJf9I7fyXiQHGHm1a\n" +
                    "DjYtXyCbU3kyZw0AEQEAAbQOU2VyZ2V5IFF1YW50dW2JAdQEEwEIAD4WIQQnFtWt\n" +
                    "sIj1D2rCnUNSUWCYJs2/4wUCYawAwQIbAwUJA8LlzwULCQgHAgYVCgkICwIEFgID\n" +
                    "AQIeAQIXgAAKCRBSUWCYJs2/43RZDACo+aKxpFWwAlfqOhNhkj4SoZPvn8hsVJ3F\n" +
                    "Td/HvVHi/8dzxYTnnvD6NsB74v/FsxAzbgugEP+FOX5KKR/Kq7c2g4Le13A/rF++\n" +
                    "9ljYCW7jt3AQXpNY3csXBdbH/ZmzCWE0LlVWDMW+xApmDHYZIsuKXKj6EeKWe/mS\n" +
                    "DPW/MBxcE4N+HGNpRgrE6jgYBcp5t/GZmYy7wf6b0xN889/qBECR8CfZKz4vI8FP\n" +
                    "OtBpFbY2lzHeQV6xW1KbWXGkR4x0gpl/ZKJBeyCUAkIjgH9rcM4TyIR9u+6lXgMF\n" +
                    "LSA60Q/UXi+HllAZDQery6al9sXAF0UuEM7Ix1ojMwwk+4lIxueYO1Zz+FmVm1Q7\n" +
                    "9d4XOjmTwiQ1GiEI8BNrxJGMyqVVq6TJaIdxWMV/AhBb2oEXIQQM9Ga4YyNxl5iL\n" +
                    "26Hf1rQUuXyB7N7tZlAxeD1SAe/YsT9H+XflQnn3RV0a/2n2HGjWJwu8DWLO2WGV\n" +
                    "kzD1htTBgin0FeXeY4v7pIIF3xlWk7i5AY0EYawAwQEMANQdqtWW9exRYvGKD+Tw\n" +
                    "Lh85c1Gvo6dWxhtpMvKepjdkXyKqxeExvoIGOkVJxMhJ6T4ZPabr8+a1g3sjiFq6\n" +
                    "bZaXA8f/OngbQk4+wJfmdfSn4J6IqC5dpHlJcYhgz4WkmDU0UeF3zNl9z6tlu22a\n" +
                    "So8oaZht7EdRhjU0f2JKmdRM3sbTd5fcwfEu3/EEfaNZK47hNqSBscQ8N2wmWqNo\n" +
                    "SjAXTXUxuUZnvR5HYJ3+QpYmyY4EndftlrllfX2dQ6i0wvEZ6OKtcmYozVYNnfv3\n" +
                    "Fa3GY59fVAcswK707Fq1at13bfA70ylDFFAj1pAJ0X9hPR02PSNXCPNNeto5JV1S\n" +
                    "g9xOdUd4XcYDyFZ1RP10mYgzjBLkipGX3hYUu3pFiMGxzmDz+DsRyZQMkF8pqY4E\n" +
                    "39XuwIEvoDAmDU40wlR/LmLOh4u/q+cy2To8bjzLn0t9RGhWk0C2RC+y1DJNgVat\n" +
                    "62Tc1D//I4Yj8fDwZr2Vo6ge8SR03GLEqtj4R1627MwGlwARAQABiQG8BBgBCAAm\n" +
                    "FiEEJxbVrbCI9Q9qwp1DUlFgmCbNv+MFAmGsAMECGwwFCQPC5c8ACgkQUlFgmCbN\n" +
                    "v+PvHQv+OomFXvj6HWG+weYFMqSK/iExUsGEBbWcaWPbcoaKC/5Q9IDT41sZUcjp\n" +
                    "p7hjQ9J+oLM/0hmn2oDdxiHErqAyVLjqZiStf5Mm0I7RLpipamnOVrMPm28CUNud\n" +
                    "5hGKaqy3g1QwFLf5GHLaU4tofVWHXlAKGo/o7xnVqeWEq3XVNAhM3tLqoXe9gNyC\n" +
                    "TGpTWrWaCVXt07FV0mAWZvAhGgidNcYZVtqr+xt3ZTGPuyRWgFgsYHqifehxdx3g\n" +
                    "0wdyNe5/RmlUkXAwaR1RnG/loLGM9WLHafag9uV9cXsS/yZSYs+kt24NO6ewTXIh\n" +
                    "KK2dKDsnpu2UB5uffWgXCzHDc15rNRHdk7jigGB10SzHK32YuP/CXTp/b2GDdzjn\n" +
                    "IkpC3PTkuf2DYprMVe5XUZoZzbLY2FNOxHwiGZduFsIonb9LBgCgW5K9rLDUqbCi\n" +
                    "ACtbYxEVe0t0/Muc3QrmiwNZ+qI8tte1EYeblo7HDf1fEjYf6qtSfZB95PpMK61B\n" +
                    "Ezl1Dtm6\n" +
                    "=Sddn\n" +
                    "-----END PGP PUBLIC KEY BLOCK-----"
        )
    )
)