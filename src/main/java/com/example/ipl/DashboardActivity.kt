package com.example.ipl

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.SharedPreferences

class DashboardActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge mode
        enableEdgeToEdge()

        // Set the layout
        setContentView(R.layout.activity_dashboard)

        // Set padding for system bars (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find buttons and set their click listeners
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            val sharedPreferences: SharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
            Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        findViewById<Button>(R.id.btnTeams).setOnClickListener {
            startActivity(Intent(this, TeamsActivity::class.java))
        }

        // Initialize dbHelper
        dbHelper = DatabaseHelper(this)

        findViewById<Button>(R.id.btnPlayerAuction).setOnClickListener {
            startActivity(Intent(this, CreatePlayerActivity::class.java))
        }




    }
}
