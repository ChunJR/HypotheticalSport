package com.chun.hypotheticalsport.presentation.team

import com.chun.hypotheticalsport.domain.model.Team

sealed class TeamState {
    data class Success(val teams: List<Team>): TeamState()
    data class Error(val exception: Throwable): TeamState()
}