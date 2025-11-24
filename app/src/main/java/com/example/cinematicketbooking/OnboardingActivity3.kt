package com.example.cinematicketbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import com.example.cinematicketbooking.R

class OnboardingActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding3)

        // Find views by ID
        val backButton = findViewById<ImageView>(R.id.back_button)
        val skipButton = findViewById<TextView>(R.id.skip_button)
        val getStartedButton = findViewById<Button>(R.id.get_started_button)

        // Back button click listener
        backButton.setOnClickListener {
            // Go back to previous onboarding screen
            val intent = Intent(this, OnboardingActivity2::class.java)
            startActivity(intent)
            finish()
        }

        // Skip button click listener
        skipButton.setOnClickListener {
            // Skip to signup page
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Get Started button click listener
        // In your OnboardingActivity3.kt, update the Get Started button click:
        getStartedButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)  // ← TO THIS
            startActivity(intent)
            finish()
        }
    }
}