package com.example.ipl

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShowPlayersActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var playerAdapter: PlayerAdapter
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("Range")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_show_players)
//
//        dbHelper = DatabaseHelper(this)
//        recyclerView = findViewById(R.id.recyclerViewPlayers)
//        recyclerView.layoutManager = LinearLayoutManager(this)

        // Insert sample players for testing
//        dbHelper.insertPlayer("Virat Kohli", "Batsman", 32, 100000)
//        dbHelper.insertPlayer("Rohit Sharma", "Batsman", 33, 80000)
//        dbHelper.insertPlayer("Jasprit Bumrah", "Bowler", 29, 60000)

        // Fetch players from the database
//        val playersList = mutableListOf<Players>()
//        val cursor = dbHelper.getAllPlayers()
//
//        if (cursor.moveToFirst()) {
//            do {
//                val playerName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_NAME))
//                val role = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_ROLE))
//                val age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_AGE))
//                val price = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_PRICE))
//
//                val player = Players(playerName, role, age, price)
//                playersList.add(player)
//            } while (cursor.moveToNext())
//        }
//        cursor.close()

        // If no players exist, show a toast
//        if (playersList.isEmpty()) {
//            Toast.makeText(this, "No players available", Toast.LENGTH_SHORT).show()
//        }
//
//        // Set up the adapter
//        val playerAdapter = PlayerAdapter(playersList)
//        recyclerView.adapter = playerAdapter
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_players)

        val dbHelper = DatabaseHelper(this)

        // Insert sample players
        dbHelper.insertPlayer("Virat Kohli", "Batsman", 32, 100000)
        dbHelper.insertPlayer("Rohit Sharma", "Batsman", 33, 80000)
        dbHelper.insertPlayer("Jasprit Bumrah", "Bowler", 29, 60000)

        // Set up RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPlayers)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch players from the database
        val playersList = mutableListOf<Players>()
        val cursor = dbHelper.getAllPlayers()

        if (cursor.moveToFirst()) {
            do {
                val playerName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_NAME))
                val role = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_ROLE))
                val age = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_AGE))
                val price = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PLAYER_PRICE))

                playersList.add(Players(playerName, role, age, price))
            } while (cursor.moveToNext())
        }
        cursor.close()

        // Attach adapter
        if (playersList.isNotEmpty()) {
            val playerAdapter = PlayerAdapter(playersList)
            recyclerView.adapter = playerAdapter
        } else {
            Toast.makeText(this, "No players available", Toast.LENGTH_SHORT).show()
        }
    }




}
