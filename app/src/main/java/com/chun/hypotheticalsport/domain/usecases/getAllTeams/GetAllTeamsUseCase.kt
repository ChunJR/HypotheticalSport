package com.chun.hypotheticalsport.domain.usecases.getAllTeams

import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.presentation.team.TeamState
import kotlinx.coroutines.flow.Flow

class GetAllTeamsUseCase(
    private val repository: Repository,
) {
    operator fun invoke(): Flow<TeamState> {
        return repository.getAllTeams()
    }
}
