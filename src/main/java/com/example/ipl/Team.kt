package com.example.ipl

data class Team(
    val name: String,
    val owner: String,
    val teamColor: String,
    val players: List<Player>
)
