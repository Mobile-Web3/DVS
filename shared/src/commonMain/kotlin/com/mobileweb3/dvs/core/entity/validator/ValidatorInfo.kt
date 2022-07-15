package com.mobileweb3.dvs.core.entity.validator

import kotlinx.serialization.Serializable

@Serializable
data class ValidatorInfo(
    val rank: Long,
    val status: Int
)