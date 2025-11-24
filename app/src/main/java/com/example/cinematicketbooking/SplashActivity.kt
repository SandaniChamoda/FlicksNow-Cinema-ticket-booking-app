package com.example.cinematicketbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {

    private lateinit var logoImageView: ImageView
    private lateinit var appNameTextView: TextView
    private lateinit var taglineTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logoImageView = findViewById(R.id.logo_image)
        appNameTextView = findViewById(R.id.app_name_text)
        taglineTextView = findViewById(R.id.tagline_text)

        startAnimations()

        // ----------------Navigate to onboarding --------------------------
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, OnboardingActivity1::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
    private fun startAnimations() {
        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_animation)
        logoImageView.startAnimation(logoAnimation)

        val nameAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_fade_in)
        appNameTextView.startAnimation(nameAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            val taglineAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            taglineTextView.startAnimation(taglineAnimation)
        }, 1000) //
    }
}