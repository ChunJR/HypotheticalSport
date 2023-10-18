package com.chun.hypotheticalsport.presentation.video_player

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.ui.theme.Purple40
import com.chun.hypotheticalsport.ui.theme.Purple80
import com.chun.hypotheticalsport.ui.theme.statusBarColor
import com.chun.hypotheticalsport.ui.theme.topAppBarContentColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VideoScreen(
    navController: NavHostController,
    viewModel: VideoViewModel = hiltViewModel(),
) {
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
                        text = "Video Player",
                        color = MaterialTheme.colors.topAppBarContentColor,
                    )
                },
                backgroundColor = if (isSystemInDarkTheme()) Purple80 else Purple40,
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = {
            VideoPlayer(
                viewModel = viewModel
            )
        },
    )
}