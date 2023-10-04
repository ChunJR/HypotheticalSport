package com.chun.hypotheticalsport.domain.model

data class MatchCategory(
    val name: String,
    val items: List<Match>
)