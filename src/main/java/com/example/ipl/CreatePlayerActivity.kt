package com.example.ipl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreatePlayerActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_player)

        dbHelper = DatabaseHelper(this)

        // Find buttons and set their click listeners
        findViewById<Button>(R.id.btnSavePlayer).setOnClickListener {
            val playerName = findViewById<EditText>(R.id.etPlayerName).text.toString()
            val role = findViewById<EditText>(R.id.etRole).text.toString()
            val price = findViewById<EditText>(R.id.etPrice).text.toString().toInt()
            val age = findViewById<EditText>(R.id.etAge).text.toString().toInt()

            dbHelper.insertPlayer(playerName, role, price, age)

            Toast.makeText(this, "Player saved successfully!", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.btnShowAllPlayers).setOnClickListener {
            startActivity(Intent(this, ShowPlayersActivity::class.java))
        }
    }
}
