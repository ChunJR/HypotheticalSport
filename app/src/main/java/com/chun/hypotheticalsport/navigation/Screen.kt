package com.chun.hypotheticalsport.navigation

sealed class Screen(val route: String) {
    object Match : Screen("match_screen")
//    object Details : Screen("details_screen/{heroId}") {
//        fun passHeroId(heroId: Int): String {
//            return "details_screen/$heroId"
//        }
//    }
    object Team : Screen("team_screen")
}
