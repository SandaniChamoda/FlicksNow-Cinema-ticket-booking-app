package com.example.cinematicketbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.cardview.widget.CardView

class MenuActivity : AppCompatActivity() {
    private lateinit var darkModeSwitch: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        findViewById<ImageView>(R.id.back_icon).setOnClickListener {
            navigateToHome()
        }

        findViewById<CardView>(R.id.profile_card).setOnClickListener {
            navigateToProfile()
        }

        findViewById<CardView>(R.id.menu_profile_details).setOnClickListener {
            navigateToProfile()
        }

        findViewById<CardView>(R.id.menu_dark_mode).setOnClickListener {
            darkModeSwitch = findViewById(R.id.dark_mode_switch)
            darkModeSwitch.toggle()
        }

        findViewById<CardView>(R.id.menu_logout).setOnClickListener {
            performLogout()
        }
    }
    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
    private fun navigateToProfile() {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
    }
    private fun performLogout() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
        finish()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        navigateToHome()
    }
}