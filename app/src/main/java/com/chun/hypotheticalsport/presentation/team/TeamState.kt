package com.chun.hypotheticalsport.presentation.team

import com.chun.hypotheticalsport.domain.model.Team

sealed class TeamState {
    object Loading: TeamState()
    data class Success(val teams: List<Team>): TeamState()
    data class Error(val errorMessage: String?): TeamState()
}