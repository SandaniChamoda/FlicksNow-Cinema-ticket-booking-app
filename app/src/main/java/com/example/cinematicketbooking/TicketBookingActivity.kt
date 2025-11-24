package com.example.cinematicketbooking

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TicketBookingActivity : AppCompatActivity() {

    private lateinit var seatRecyclerView: RecyclerView
    private lateinit var seatAdapter: SeatAdapter

    private val selectedSeats = mutableListOf<Int>()
    private val totalSeats = 70

    private lateinit var movieTitle: String
    private var movieImage: Int = R.drawable.film1
    private var fromNavigation: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_booking)

        movieTitle = intent.getStringExtra("MOVIE_TITLE") ?: "Unknown Movie"
        movieImage = intent.getIntExtra("MOVIE_IMAGE", R.drawable.film1)
        fromNavigation = intent.getBooleanExtra("FROM_NAV", false)

        Log.d("TicketBooking", "Movie: $movieTitle, From Navigation: $fromNavigation")

        initializeViews()
        setupSeatGrid()
        setupClickListeners()
        setupDateSelection()
        setupTimeSelection()
        setupFormatSelection()
    }

    private fun initializeViews() {
        seatRecyclerView = findViewById(R.id.seat_recycler_view)
    }

    private fun setupSeatGrid() {
        val seatList = createSeatList()
        seatRecyclerView.layoutManager = GridLayoutManager(this, 10)
        seatAdapter = SeatAdapter(seatList) { position ->
            handleSeatClick(position)
        }
        seatRecyclerView.adapter = seatAdapter
    }

    private fun createSeatList(): List<Seat> {
        val seats = mutableListOf<Seat>()
        val reservedSeats = setOf(5, 6, 15, 16, 25, 26, 35, 36) // Some pre-reserved seats

        for (i in 0 until totalSeats) {
            val seatType = when {
                reservedSeats.contains(i) -> SeatType.RESERVED
                else -> SeatType.AVAILABLE
            }
            seats.add(Seat(i, seatType))
        }
        return seats
    }

    private fun handleSeatClick(position: Int) {
        if (selectedSeats.contains(position)) {
            selectedSeats.remove(position)
        } else {
            if (selectedSeats.size < 6) {
                selectedSeats.add(position)
            } else {
                return
            }
        }

        seatAdapter.updateSelectedSeats(selectedSeats)
    }

    private fun setupClickListeners() {
        findViewById<ImageView>(R.id.back_icon).setOnClickListener {
            if (fromNavigation) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, MovieDetailsActivity::class.java)
                intent.putExtra("MOVIE_TITLE", movieTitle)
                intent.putExtra("MOVIE_IMAGE", movieImage)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }
        }

        findViewById<CardView>(R.id.pay_button).setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun setupDateSelection() {
        val dateCards = listOf(
            findViewById<CardView>(R.id.date_fri),
            findViewById<CardView>(R.id.date_sat),
            findViewById<CardView>(R.id.date_sun),
            findViewById<CardView>(R.id.date_mon),
            findViewById<CardView>(R.id.date_tue),
            findViewById<CardView>(R.id.date_wed),
            findViewById<CardView>(R.id.date_thu)
        )
        dateCards.forEachIndexed { _, card ->
            card.setOnClickListener {
                dateCards.forEach { it.setCardBackgroundColor(resources.getColor(R.color.background_dark)) }
                card.setCardBackgroundColor(resources.getColor(R.color.primary_purple))
            }
        }
    }

    private fun setupTimeSelection() {
        val timeCards = listOf(
            findViewById<CardView>(R.id.time_9am),
            findViewById<CardView>(R.id.time_12pm),
            findViewById<CardView>(R.id.time_3pm),
            findViewById<CardView>(R.id.time_6pm), // This one is pre-selected in XML
            findViewById<CardView>(R.id.time_8pm)
        )

        timeCards.forEachIndexed { _, card ->
            card.setOnClickListener {
                timeCards.forEach { it.setCardBackgroundColor(resources.getColor(R.color.background_dark)) }
                card.setCardBackgroundColor(resources.getColor(R.color.primary_purple))
            }
        }
    }

    private fun setupFormatSelection() {
        val formatCards = listOf(
            findViewById<CardView>(R.id.format_2d), // This one is pre-selected in XML
            findViewById<CardView>(R.id.format_3d),
            findViewById<CardView>(R.id.format_imax)
        )

        formatCards.forEachIndexed { _, card ->
            card.setOnClickListener {
                formatCards.forEach { it.setCardBackgroundColor(resources.getColor(R.color.background_dark)) }
                card.setCardBackgroundColor(resources.getColor(R.color.primary_purple))
            }
        }
    }
}
