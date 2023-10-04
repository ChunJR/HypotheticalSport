package com.chun.hypotheticalsport.domain.repository

import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllTeams(): Flow<List<Team>>
    fun getAllMatches(): Flow<List<Match>>
}
