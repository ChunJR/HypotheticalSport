package com.chun.hypotheticalsport.presentation.match

import android.service.autofill.FieldClassification.Match
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chun.hypotheticalsport.data.repository.Repository
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

    fun fetchData() = viewModelScope.launch {
        val getAllTeams = useCases.getAllTeamsUseCase().collect()
        Log.e("RESPONSE", getAllTeams.toString() ?: "failed to fetch")
    }
}

// Represents different states for the LatestNews screen
sealed class LoadingState {
    data class Success(val news: List<Match>): LoadingState()
    data class Error(val exception: Throwable): LoadingState()
}
