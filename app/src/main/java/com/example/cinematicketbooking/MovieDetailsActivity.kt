package com.example.cinematicketbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieTitle = intent.getStringExtra("MOVIE_TITLE")
            ?: getString(R.string.unknown_movie)    //get movie title form home activity
        val movieImage = intent.getIntExtra(
            "MOVIE_IMAGE",
            R.drawable.film1
        )         //get movie image from home activity

        findViewById<TextView>(R.id.movie_title).text = movieTitle
        findViewById<ImageView>(R.id.movie_banner).setImageResource(movieImage)

        // Back button
        findViewById<ImageView>(R.id.back_icon).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

        // Book Ticket button
        findViewById<androidx.cardview.widget.CardView>(R.id.book_ticket_btn).setOnClickListener {
            val intent = Intent(this, TicketBookingActivity::class.java)
            intent.putExtra("MOVIE_TITLE", movieTitle)
            intent.putExtra("MOVIE_IMAGE", movieImage)
            startActivity(intent)
        }

    }
}