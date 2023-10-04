package com.chun.hypotheticalsport.presentation.match

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.ui.theme.Purple40
import com.chun.hypotheticalsport.ui.theme.Purple80
import com.chun.hypotheticalsport.ui.theme.topAppBarContentColor

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MatchScreen(
    viewModel: MatchViewModel = hiltViewModel(),
) {
//    val matchList by viewModel.getAllMatches.collectAsState(initial = emptyList<Match>())
    viewModel.fetchData()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Matches",
                        color = MaterialTheme.colors.topAppBarContentColor,
                    )
                },
                backgroundColor = if (isSystemInDarkTheme()) Purple80 else Purple40,
            )
        },
        content = {
//            CategorizedLazyColumn(
//                categories = matchList
//            )
        },
    )
}
