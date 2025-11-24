package com.example.cinematicketbooking

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Back button functionality
        findViewById<ImageView>(R.id.back_icon).setOnClickListener {
            finish() // Go back to previous activity
        }

        // Save Changes button functionality
        findViewById<CardView>(R.id.save_changes_btn).setOnClickListener {


            // Navigate back to home page
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // Profile image click (optional - for future image selection)
        findViewById<ImageView>(R.id.profile_image).setOnClickListener {
            Toast.makeText(this, "Change profile picture", Toast.LENGTH_SHORT).show()
            // TODO: Implement image picker functionality
        }
    }
}