package com.chun.hypotheticalsport.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TeamResponse(
    val teams: List<Team> = emptyList()
)

@Serializable
data class MatchResponse(
    val matches: MatchDataResponse
)

@Serializable
data class MatchDataResponse(
    val previous: List<Match> = emptyList(),
    val upcoming: List<Match> = emptyList()
)
