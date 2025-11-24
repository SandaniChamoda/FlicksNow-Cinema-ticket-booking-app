package com.example.cinematicketbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var moviesRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        moviesRecyclerView = findViewById(R.id.movies_recycler_view) //set adapter

        moviesRecyclerView.layoutManager = GridLayoutManager(this, 3)     //3 grid view images

        val movieList = createMovieList()     //movie list

        movieAdapter = MovieAdapter(movieList) { movie ->                                // Set up adapter with click handling
            // Handle movie click - Navigate to movie details
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("MOVIE_TITLE", movie.title)
            intent.putExtra("MOVIE_IMAGE", movie.imageResource)
            startActivity(intent)
        }
        moviesRecyclerView.adapter = movieAdapter

        setupNavigationClicks()
    }

    //nav bar
    private fun setupNavigationClicks() {
        findViewById<LinearLayout>(R.id.nav_profile).setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        findViewById<LinearLayout>(R.id.nav_home).setOnClickListener {
        }

        findViewById<LinearLayout>(R.id.nav_ticket).setOnClickListener {
            val intent = Intent(this, TicketBookingActivity::class.java)
            intent.putExtra("MOVIE_TITLE", "Select a Movie") // Default title when coming from bottom nav
            intent.putExtra("MOVIE_IMAGE", R.drawable.film1) // Default image
            intent.putExtra("FROM_NAV", true) // Flag to indicate source
            startActivity(intent)
        }

        findViewById<LinearLayout>(R.id.nav_theater).setOnClickListener {
        }

        findViewById<ImageView>(R.id.menu_icon).setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.notification_icon).setOnClickListener {
        }

        findViewById<androidx.cardview.widget.CardView>(R.id.featured_movie_card).setOnClickListener {
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("MOVIE_TITLE", "Featured Movie")
            intent.putExtra("MOVIE_IMAGE", R.drawable.film10)
            startActivity(intent)
        }
    }
    private fun createMovieList(): List<Movie> {
        return listOf(
            Movie("Elite", R.drawable.film1),
            Movie("Lupin", R.drawable.film2),
            Movie("Murder Mystery", R.drawable.film3),
            Movie("Hustle", R.drawable.film4),
            Movie("Luther", R.drawable.film5),
            Movie("Bridgerton", R.drawable.film6),
            Movie("Red Notice", R.drawable.film7),
            Movie("Enola Homes", R.drawable.film8),
            Movie("Bridgerton", R.drawable.film9)
        )
    }
}