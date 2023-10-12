package com.chun.hypotheticalsport.data.repository

import com.chun.hypotheticalsport.domain.repository.RemoteDataSource
import com.chun.hypotheticalsport.presentation.match.MatchState
import com.chun.hypotheticalsport.presentation.team.TeamState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    fun getAllMatches(): Flow<MatchState> {
        return remoteDataSource.getAllMatches()
    }

    fun getAllTeams(): Flow<TeamState> {
        return remoteDataSource.getAllTeams()
    }

    fun getTeamMatches(id: String): Flow<MatchState> {
        return remoteDataSource.getTeamMatches(id)
    }
}
