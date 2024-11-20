package com.example.ipl

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.ipl.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up View Binding
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load fade-in animation
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        binding.iplLogo.startAnimation(fadeInAnimation)
        binding.appName.startAnimation(fadeInAnimation)

        // Delay and navigate to MainActivity
        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close SplashActivity
        }, 3000) // 3 seconds delay
    }
}
