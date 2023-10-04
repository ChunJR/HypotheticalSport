package com.chun.hypotheticalsport.domain.usecases.getAllMatches

import androidx.paging.PagingData
import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.domain.model.Match
import kotlinx.coroutines.flow.Flow

class GetAllMatchesUseCase(
    private val repository: Repository,
) {
    operator fun invoke(): Flow<List<Match>> {
        return repository.getAllMatches()
    }
}
