package com.chun.hypotheticalsport.domain.usecases.getAllTeams

import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.domain.model.Team
import kotlinx.coroutines.flow.Flow

class GetAllTeamsUseCase(
    private val repository: Repository,
) {
    operator fun invoke(): Flow<List<Team>> {
        return repository.getAllTeams()
    }
}
