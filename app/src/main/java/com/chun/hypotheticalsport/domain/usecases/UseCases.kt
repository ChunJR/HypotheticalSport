package com.chun.hypotheticalsport.domain.usecases

import com.chun.hypotheticalsport.domain.usecases.getAllMatches.GetAllMatchesUseCase
import com.chun.hypotheticalsport.domain.usecases.getAllTeams.GetAllTeamsUseCase

data class UseCases(
    val getAllMatchesUseCase: GetAllMatchesUseCase,
    val getAllTeamsUseCase: GetAllTeamsUseCase,
)
