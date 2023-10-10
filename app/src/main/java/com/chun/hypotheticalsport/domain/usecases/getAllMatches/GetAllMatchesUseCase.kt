package com.chun.hypotheticalsport.domain.usecases.getAllMatches

import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.domain.model.MatchDataResponse
import com.chun.hypotheticalsport.presentation.match.MatchState
import kotlinx.coroutines.flow.Flow

class GetAllMatchesUseCase(
    private val repository: Repository,
) {
    operator fun invoke(): Flow<MatchState> {
        return repository.getAllMatches()
    }
}
