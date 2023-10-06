package com.chun.hypotheticalsport.data.repository

import com.chun.hypotheticalsport.data.remote.SportApi
import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.domain.model.MatchDataResponse
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.domain.repository.RemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSourceImpl (
    private val sportApi: SportApi,
    ) : RemoteDataSource {

    override fun getAllTeams(): Flow<List<Team>> {
        return flow {
            val teams = sportApi.getAllTeams().teams
            emit(teams)
        }.flowOn(Dispatchers.IO)
    }

    override fun getAllMatches(): Flow<MatchDataResponse> {
        return flow {
            val matches = sportApi.getAllMatches().matches
            emit(matches)
        }.flowOn(Dispatchers.IO)
    }

}