package com.chun.hypotheticalsport.domain.repository

import com.chun.hypotheticalsport.presentation.match.MatchState
import com.chun.hypotheticalsport.presentation.team.TeamState
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllTeams(): Flow<TeamState>
    fun getAllMatches(): Flow<MatchState>
}
