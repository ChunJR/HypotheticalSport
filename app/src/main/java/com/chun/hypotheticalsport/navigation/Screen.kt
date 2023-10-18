package com.chun.hypotheticalsport.navigation

import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.util.Constants.TEAM_MATCH_ARGUMENT_KEY
import com.chun.hypotheticalsport.util.Constants.VIDEO_PLAYER_ARGUMENT_KEY

sealed class Screen(val route: String) {
    object Match : Screen("match_screen")
    object Team : Screen("team_screen")
    object TeamMatch : Screen("team_match_screen/{$TEAM_MATCH_ARGUMENT_KEY}") {
        fun passId(id: String): String {
            return "team_match_screen/$id"
        }
    }
    object VideoPlayer : Screen("video_screen/{$VIDEO_PLAYER_ARGUMENT_KEY}") {
        fun passMatchDetail(match: String): String {
            return "video_screen/$match"
        }
    }
}
