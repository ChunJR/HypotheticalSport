package com.chun.hypotheticalsport.navigation

sealed class Screen(val route: String) {
    object Match : Screen("match_screen")
    object Team : Screen("team_screen")
    object TeamMatch : Screen("team_match_screen/{id}") {
        fun passId(id: String): String {
            return "team_match_screen/$id"
        }
    }
}
