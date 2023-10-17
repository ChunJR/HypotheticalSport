package com.chun.hypotheticalsport.remote

import com.chun.hypotheticalsport.data.remote.SportApi
import com.chun.hypotheticalsport.domain.model.Match
import com.chun.hypotheticalsport.domain.model.MatchDataResponse
import com.chun.hypotheticalsport.domain.model.MatchResponse
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.domain.model.TeamResponse

class FakeSportApi : SportApi {
    private val teams = listOf(
        Team(
            id = "767ec50c-7fdb-4c3d-98f9-d6727ef8252b",
            name = "Team Red Dragons",
            logo = "https://tstzj.s3.amazonaws.com/dragons.png",
        ),
        Team(
            id = "7b4d8114-742b-4410-971a-500162101158",
            name = "Team Cool Eagles",
            logo = "https://tstzj.s3.amazonaws.com/eagle.png",
        ),
        Team(
            id = "efb06ca2-78bc-448e-bda5-a6af9eccdcd0",
            name = "Team Chill Elephants",
            logo = "https://tstzj.s3.amazonaws.com/elephant.png",
        ),
    )

    private val prevMatches = listOf(
        Match(
            date = "2022-04-23T18:00:00.000Z",
            description = "Team Cool Eagles vs. Team Red Dragons",
            home = "Team Cool Eagles",
            away = "Team Red Dragons",
            winner = "Team Red Dragons",
            highlights = "https://tstzj.s3.amazonaws.com/highlights.mp4",
        ),
        Match(
            date = "2022-04-24T18:00:00.000Z",
            description = "Team Chill Elephants vs. Team Royal Knights",
            home = "Team Chill Elephants",
            away = "Team Royal Knights",
            winner = "Team Chill Elephants",
            highlights = "https://tstzj.s3.amazonaws.com/highlights.mp4",
        ),
    )

    private val upcomingMatches = listOf(
        Match(
            date = "2022-04-23T18:00:00.000Z",
            description = "Team Cool Eagles vs. Team Red Dragons",
            home = "Team Cool Eagles",
            away = "Team Red Dragons",
        ),
        Match(
            date = "2022-04-24T18:00:00.000Z",
            description = "Team Chill Elephants vs. Team Royal Knights",
            home = "Team Chill Elephants",
            away = "Team Royal Knights",
        ),
    )

    override suspend fun getAllTeams(): TeamResponse {
        return TeamResponse(
            teams = teams,
        )
    }

    override suspend fun getAllMatches(): MatchResponse {
        return MatchResponse(
            matches = MatchDataResponse(
                previous = prevMatches,
                upcoming = upcomingMatches
            ),
        )
    }

    override suspend fun getTeamMatches(id: String): MatchResponse {
        return MatchResponse(
            matches = MatchDataResponse(
                previous = prevMatches,
                upcoming = upcomingMatches
            ),
        )
    }
}
