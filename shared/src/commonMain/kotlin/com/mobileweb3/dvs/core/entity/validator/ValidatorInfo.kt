package com.mobileweb3.dvs.core.entity.validator

import kotlinx.serialization.Serializable

@Serializable
data class ValidatorInfo(
    val rank: Long? = null,
    val status: Int
)

fun ValidatorInfo?.getRankString(): String {
    return this?.rank?.toString() ?: "UNKNOWN"
}

fun ValidatorInfo?.getStatusString(): String {
    return ValidatorStatus.from(this?.status)
}