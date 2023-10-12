package com.chun.hypotheticalsport.presentation.team_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chun.hypotheticalsport.domain.usecases.UseCases
import com.chun.hypotheticalsport.presentation.match.MatchState
import com.chun.hypotheticalsport.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamMatchViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MatchState>(MatchState.Loading)
    val uiState: StateFlow<MatchState> = _uiState

    init {
        viewModelScope.launch {
            val id = savedStateHandle.get<String>(Constants.TEAM_MATCH_ARGUMENT_KEY)
            id?.let {
                useCases.getTeamMatchesUseCase(it)
                    .collect { state ->
                        _uiState.value = state
                    }
            } ?: run {
                _uiState.value = MatchState.Error("ID Invalid")
            }
        }
    }
}
