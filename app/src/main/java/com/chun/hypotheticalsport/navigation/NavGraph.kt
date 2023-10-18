package com.chun.hypotheticalsport.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.chun.hypotheticalsport.domain.model.BottomNavItem
import com.chun.hypotheticalsport.presentation.match.MatchScreen
import com.chun.hypotheticalsport.presentation.team.TeamScreen
import com.chun.hypotheticalsport.presentation.team_detail.TeamMatchScreen
import com.chun.hypotheticalsport.presentation.video_player.VideoScreen
import com.chun.hypotheticalsport.ui.theme.Purple80

@Composable
fun SetUpNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.Match.route) {
            MatchScreen(navController = navController)
        }
        composable(route = Screen.Team.route) {
            TeamScreen(navController = navController)
        }
        composable(route = Screen.TeamMatch.route) {
            TeamMatchScreen(navController = navController)
        }
        composable(route = Screen.VideoPlayer.route) {
            VideoScreen(navController = navController)
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Purple80,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                        if(selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp,
                                color = Purple80
                            )
                        }
                    }
                }
            )
        }
    }
}
