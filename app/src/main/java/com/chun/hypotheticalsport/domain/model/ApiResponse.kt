package com.chun.hypotheticalsport.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamResponse(
    @SerialName("teams") val teams: List<Team> = emptyList()
)

@Serializable
data class MatchResponse(
    @SerialName("previous") val previous: List<Match> = emptyList(),
    @SerialName("upcoming") val upcoming: List<Match> = emptyList()
)
