package com.chun.hypotheticalsport.presentation.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chun.hypotheticalsport.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _uiState = MutableStateFlow<TeamState>(TeamState.Loading)
    val uiState: StateFlow<TeamState> = _uiState

    init {
        viewModelScope.launch {
            useCases.getAllTeamsUseCase()
                .collect { state ->
                    _uiState.value = state
                }
        }
    }
}
