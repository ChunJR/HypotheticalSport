package com.chun.hypotheticalsport.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: String,
    val name: String,
    val logo: String,
)
