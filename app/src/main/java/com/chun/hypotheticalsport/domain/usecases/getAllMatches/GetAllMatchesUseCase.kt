package com.chun.hypotheticalsport.domain.usecases.getAllMatches

import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.domain.model.MatchDataResponse
import kotlinx.coroutines.flow.Flow

class GetAllMatchesUseCase(
    private val repository: Repository,
) {
    operator fun invoke(): Flow<MatchDataResponse> {
        return repository.getAllMatches()
    }
}
