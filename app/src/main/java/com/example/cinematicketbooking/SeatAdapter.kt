package com.example.cinematicketbooking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SeatAdapter(
    private val seats: List<Seat>,
    private val onSeatClick: (Int) -> Unit
) : RecyclerView.Adapter<SeatAdapter.SeatViewHolder>() {

    private var selectedSeats = mutableListOf<Int>()

    class SeatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val seatCard: CardView = itemView.findViewById(R.id.seat_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_seat, parent, false)
        return SeatViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeatViewHolder, position: Int) {
        val seat = seats[position]
        val context = holder.itemView.context

        when {
            selectedSeats.contains(position) -> {
                // Selected seat
                holder.seatCard.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.selected_seat)
                )
            }
            seat.type == SeatType.RESERVED -> {
                // Reserved seat
                holder.seatCard.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.reserved_seat)
                )
            }
            else -> {
                // Available seat
                holder.seatCard.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.available_seat)
                )
            }
        }

        holder.seatCard.setOnClickListener {
            if (seat.type == SeatType.AVAILABLE || selectedSeats.contains(position)) {
                onSeatClick(position)
            }
        }
    }

    override fun getItemCount(): Int = seats.size

    fun updateSelectedSeats(newSelectedSeats: List<Int>) {
        selectedSeats.clear()
        selectedSeats.addAll(newSelectedSeats)
        notifyDataSetChanged()
    }
}