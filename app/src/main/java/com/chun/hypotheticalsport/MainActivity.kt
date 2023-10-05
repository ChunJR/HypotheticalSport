package com.chun.hypotheticalsport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.chun.hypotheticalsport.domain.model.BottomNavItem
import com.chun.hypotheticalsport.navigation.BottomNavigationBar
import com.chun.hypotheticalsport.navigation.Screen
import com.chun.hypotheticalsport.navigation.SetUpNavGraph
import com.chun.hypotheticalsport.ui.theme.HypotheticalSportTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            HypotheticalSportTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Matches",
                                    route = Screen.Match.route,
                                    icon = Icons.Default.DateRange
                                ),
                                BottomNavItem(
                                    name = "Teams",
                                    route = Screen.Team.route,
                                    icon = Icons.Default.AccountBox
                                ),
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        SetUpNavGraph(
                            navController = navController,
                            startDestination = Screen.Match.route
                        )
                    }
                }
            }
        }
    }
}