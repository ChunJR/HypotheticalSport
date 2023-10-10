package com.chun.hypotheticalsport.presentation.match

import android.service.autofill.FieldClassification.Match
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chun.hypotheticalsport.data.repository.Repository
import com.chun.hypotheticalsport.domain.model.MatchDataResponse
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MatchState>(MatchState.Loading)
    val uiState: StateFlow<MatchState> = _uiState

    init {
        viewModelScope.launch {
            useCases.getAllMatchesUseCase()
                .collect { state ->
                    _uiState.value = state
                }
        }
    }
}
