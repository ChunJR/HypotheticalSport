package com.chun.hypotheticalsport.domain.usecases

import com.chun.hypotheticalsport.domain.usecases.getAllMatches.GetAllMatchesUseCase
import com.chun.hypotheticalsport.domain.usecases.getAllTeams.GetAllTeamsUseCase
import com.chun.hypotheticalsport.domain.usecases.getTeamMatches.GetTeamMatchesUseCase

data class UseCases(
    val getAllMatchesUseCase: GetAllMatchesUseCase,
    val getAllTeamsUseCase: GetAllTeamsUseCase,
    val getTeamMatchesUseCase: GetTeamMatchesUseCase,
)
