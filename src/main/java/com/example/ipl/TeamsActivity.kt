package com.example.ipl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TeamsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teamsAdapter: TeamsAdapter
    private val teamsList = listOf(
        Team("Mumbai Indians", "Mukesh Ambani", "#003B73", listOf(
            Player("Rohit Sharma(Captain)", 36),
            Player("Hardik Pandya", 30),
            Player("Jasprit Bumrah", 30),
            Player("Kieron Pollard", 36)
        )),
        Team("Chennai Super Kings", "N. Srinivasan", "#FFCC00", listOf(
            Player("MS Dhoni(Captain)", 43),
            Player("Ravindra Jadeja", 35),
            Player("Ambati Rayudu", 38),
            Player("Moeen Ali", 36)
        )),
        Team("Royal Challengers Bangalore", "Vijay Mallya", "#9B0000", listOf(
            Player("Virat Kohli(Captain)", 35),
            Player("Glenn Maxwell", 35),
            Player("Faf du Plessis", 39),
            Player("Dinesh Karthik", 38)
        )),
        Team("Delhi Capitals", "JSW Group", "#0066B3", listOf(
            Player("Rishabh Pant(Captain)", 26),
            Player("David Warner", 37),
            Player("Shreyas Iyer", 29),
            Player("Prithvi Shaw", 24)
        ))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.teamsLayout)
            .setBackgroundColor(android.graphics.Color.parseColor("#ADD8E6"))

        recyclerView = findViewById(R.id.teamsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        teamsAdapter = TeamsAdapter(teamsList) { team ->
            val intent = Intent(this, TeamPlayersActivity::class.java)
            intent.putExtra("TEAM_NAME", team.name)
            intent.putParcelableArrayListExtra("PLAYERS_LIST", ArrayList(team.players))  // Passing players list
            startActivity(intent)
        }

        recyclerView.adapter = teamsAdapter
    }
}
