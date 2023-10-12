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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.chun.hypotheticalsport.ui.theme.Purple40
import com.chun.hypotheticalsport.ui.theme.Purple80
import com.chun.hypotheticalsport.ui.theme.statusBarColor
import com.chun.hypotheticalsport.ui.theme.topAppBarContentColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MatchScreen(
    navController: NavHostController,
    viewModel: MatchViewModel = hiltViewModel(),
) {
    val matchList = viewModel.uiState.collectAsState()

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.statusBarColor
    SideEffect {
        systemUiController.setSystemBarsColor(color = systemBarColor)
    }

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
            MatchLazyColumn(
                state = matchList
            )
        },
    )
}