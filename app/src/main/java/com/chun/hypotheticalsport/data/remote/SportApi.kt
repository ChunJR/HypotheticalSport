package com.chun.hypotheticalsport.data.remote

import com.chun.hypotheticalsport.domain.model.MatchResponse
import com.chun.hypotheticalsport.domain.model.TeamResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SportApi {

    @GET("/teams")
    suspend fun getAllTeams(): TeamResponse

    @GET("/teams/matches")
    suspend fun getAllMatches(): MatchResponse

    @GET("/teams/{id}/matches")
    suspend fun getTeamMatches(@Path("id") id: String): MatchResponse

}
