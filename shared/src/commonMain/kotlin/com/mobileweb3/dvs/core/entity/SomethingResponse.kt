package com.mobileweb3.dvs.core.entity

import kotlinx.serialization.Serializable

@Serializable
data class SomethingResponse(
    val data: List<Something>
)