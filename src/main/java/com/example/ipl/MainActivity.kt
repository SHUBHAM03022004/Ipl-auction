package com.example.ipl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ipl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Home"
        binding.tvHelloWorld.text = "Hello, World!"
    }
}
