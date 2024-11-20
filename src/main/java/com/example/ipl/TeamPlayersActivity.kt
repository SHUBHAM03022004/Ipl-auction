package com.example.ipl

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TeamPlayersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_players)

        val teamName = intent.getStringExtra("TEAM_NAME")
        val playersList: ArrayList<Player>? = intent.getParcelableArrayListExtra("PLAYERS_LIST")

        val teamNameTextView: TextView = findViewById(R.id.teamNameTextView)
        teamNameTextView.text = teamName

        val playersTextView: TextView = findViewById(R.id.playersTextView)
        val playersText = playersList?.joinToString(separator = "\n") {
            "${it.name}, Age: ${it.age}"
        }
        playersTextView.text = playersText
    }
}
