package com.example.cinematicketbooking

data class Seat(
    val position: Int,
    val type: SeatType
)

enum class SeatType {
    AVAILABLE,
    RESERVED,
    SELECTED
}