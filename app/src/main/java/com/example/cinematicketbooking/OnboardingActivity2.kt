package com.example.cinematicketbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import com.example.cinematicketbooking.R

class OnboardingActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        // Find views by ID
        val backButton = findViewById<ImageView>(R.id.back_button)
        val skipButton = findViewById<TextView>(R.id.skip_button)
        val nextButton = findViewById<Button>(R.id.next_button)

        // Back button click listener
        backButton.setOnClickListener {
            // Go back to previous onboarding screen
            val intent = Intent(this, OnboardingActivity1::class.java)
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

        // Next button click listener
        nextButton.setOnClickListener {
            // Go to next onboarding screen
            val intent = Intent(this, OnboardingActivity3::class.java)
            startActivity(intent)
            finish()
        }
    }
}