package com.chun.hypotheticalsport.presentation.match

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.ui.theme.Purple40
import com.chun.hypotheticalsport.ui.theme.topAppBarContentColor

@ExperimentalFoundationApi
@Composable
fun MatchLazyColumn(
    state: State<LoadingState>,
    modifier: Modifier = Modifier
) {
    val teams = handleResult(state = state)
    LazyColumn(
        modifier = modifier
    ) {
        stickyHeader {
            CategoryHeader("Teams")
        }
        items(teams) { team ->
            CategoryItem(team)
        }
    }
}

@Composable
private fun CategoryHeader(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(Purple40)
            .padding(16.dp)
    )
}

@Composable
private fun CategoryItem(
    team: Team,
    modifier: Modifier = Modifier
) {
    Text(
        text = team.name,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.topAppBarContentColor)
            .padding(16.dp)
    )
}

@Composable
fun handleResult(
    state: State<LoadingState>,
): List<Team> {
    return when (state.value) {
        is LoadingState.Success -> (state.value as LoadingState.Success).teams
        is LoadingState.Error -> emptyList()
    }
}