package com.chun.hypotheticalsport.data.repository

import androidx.paging.PagingData
import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.domain.model.MatchDataResponse
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {

    fun getAllMatches(): Flow<MatchDataResponse> {
        return remoteDataSource.getAllMatches()
    }

    fun getAllTeams(): Flow<List<Team>> {
        return remoteDataSource.getAllTeams()
    }
}
