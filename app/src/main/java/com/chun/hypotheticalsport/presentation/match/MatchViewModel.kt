package com.chun.hypotheticalsport.presentation.match

import android.service.autofill.FieldClassification.Match
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    val getAllTeams = useCases.getAllTeamsUseCase()

    // Backing property to avoid state updates from other classes
    private val _uiState = MutableStateFlow(LoadingState.Success(emptyList()))
    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<LoadingState> = _uiState

    init {
        viewModelScope.launch {
            useCases.getAllTeamsUseCase()
                // Update View with the latest favorite news
                // Writes to the value property of MutableStateFlow,
                // adding a new element to the flow and updating all
                // of its collectors
                .collect { teams ->
                    _uiState.value = LoadingState.Success(teams)
                }
        }
    }
}

// Represents different states for the LatestNews screen
sealed class LoadingState {
    data class Success(val teams: List<Team>): LoadingState()
    data class Error(val exception: Throwable): LoadingState()
}
