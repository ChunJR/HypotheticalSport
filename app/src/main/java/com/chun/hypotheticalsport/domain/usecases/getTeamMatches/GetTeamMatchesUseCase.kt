package com.chun.hypotheticalsport.domain.usecases.getTeamMatches

import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.presentation.match.MatchState
import kotlinx.coroutines.flow.Flow

class GetTeamMatchesUseCase(
    private val repository: Repository,

) {
    operator fun invoke(id: String): Flow<MatchState> {
        return repository.getTeamMatches(id)
    }
}
