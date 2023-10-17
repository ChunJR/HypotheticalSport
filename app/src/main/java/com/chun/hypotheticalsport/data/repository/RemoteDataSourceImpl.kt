package com.chun.hypotheticalsport.data.repository

import com.chun.hypotheticalsport.data.remote.SportApi
import com.chun.hypotheticalsport.domain.repository.RemoteDataSource
import com.chun.hypotheticalsport.presentation.match.MatchState
import com.chun.hypotheticalsport.presentation.team.TeamState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSourceImpl (
    private val sportApi: SportApi,
    ) : RemoteDataSource {

    override fun getAllTeams(): Flow<TeamState> {
        return flow {
            emit(TeamState.Loading)
            try {
                val data = sportApi.getAllTeams()
                emit(TeamState.Success(data.teams))
            } catch (exception: Exception) {
                emit(TeamState.Error("Internet Issues"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getAllMatches(): Flow<MatchState> {
        return flow {
            emit(MatchState.Loading)
            try {
                val data = sportApi.getAllMatches()
                emit(MatchState.Success(data.matches))
            } catch (exception: Exception) {
                emit(MatchState.Error("Internet Issues"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getTeamMatches(id: String): Flow<MatchState> {
        return flow {
            emit(MatchState.Loading)
            try {
                val data = sportApi.getTeamMatches(id)
                emit(MatchState.Success(data.matches))
            } catch (exception: Exception) {
                emit(MatchState.Error("Internet Issues"))
            }
        }.flowOn(Dispatchers.IO)
    }

}