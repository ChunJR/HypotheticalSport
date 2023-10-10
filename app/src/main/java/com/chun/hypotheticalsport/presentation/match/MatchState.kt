package com.chun.hypotheticalsport.presentation.match

import com.chun.hypotheticalsport.domain.model.MatchDataResponse

sealed class MatchState {
    object Loading: MatchState()
    data class Success(val matches: MatchDataResponse): MatchState()
    data class Error(val errorMessage: String?): MatchState()
}