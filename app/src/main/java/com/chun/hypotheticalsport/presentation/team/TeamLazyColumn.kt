package com.chun.hypotheticalsport.presentation.team

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.chun.hypotheticalsport.R
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.presentation.common.EmptyScreen
import com.chun.hypotheticalsport.presentation.common.ShimmerEffect
import com.chun.hypotheticalsport.presentation.match.MatchState
import com.chun.hypotheticalsport.ui.theme.LARGE_PADDING
import com.chun.hypotheticalsport.ui.theme.Purple40
import com.chun.hypotheticalsport.ui.theme.PurpleGrey80
import com.chun.hypotheticalsport.ui.theme.buttonBgColor
import com.chun.hypotheticalsport.ui.theme.topAppBarContentColor

@ExperimentalFoundationApi
@Composable
fun TeamLazyColumn(
    state: State<TeamState>,
    modifier: Modifier = Modifier
) {
    val isValid = handleResult(state = state)
    if (isValid) {
        val teams = (state.value as TeamState.Success).teams
        LazyColumn(
            modifier = modifier
        ) {
            items(teams) { team ->
                CategoryItem(team)
            }
        }
    }
}

@Composable
private fun CategoryItem(
    team: Team,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 0.dp,
        backgroundColor = PurpleGrey80
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Surface(shape = RoundedCornerShape(size = LARGE_PADDING)) {
                AsyncImage(
                    modifier = modifier
                        .weight(1.0f, true)
                        .height(100.dp)
                        .width(100.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data = team.logo)
                        .placeholder(drawableResId = R.drawable.baseline_fireplace_24)
                        .error(drawableResId = R.drawable.baseline_fireplace_24)
                        .build(),
                    contentDescription = stringResource(id = R.string.team_logo),
                    contentScale = ContentScale.Inside,
                )
            }
            Column(
                modifier = modifier
                    .weight(2.0f, true)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = team.name,
                    fontSize = 14.sp,
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.buttonBgColor,
                        contentColor = Color.White,
                    ),
                ) {
                    Text(
                        text = "View Team Matches",
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun handleResult(
    state: State<TeamState>,
): Boolean {
    return when (state.value) {
        is TeamState.Success -> true
        is TeamState.Loading -> {
            ShimmerEffect()
            false
        }
        is TeamState.Error -> {
            val message = (state.value as TeamState.Error).errorMessage
            EmptyScreen(message)
            false
        }
    }
}