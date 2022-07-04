package com.mobileweb3.basic_kmm_sample.core.entity

import kotlinx.serialization.Serializable

@Serializable
data class SomethingResponse(
    val data: List<Something>
)