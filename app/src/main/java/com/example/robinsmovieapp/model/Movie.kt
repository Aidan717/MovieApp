package com.example.robinsmovieapp.model

import android.media.Image
import java.util.*

class Movie(val title: String, val genre: Genre, val releaseDate: String, val reviews: MutableList<Review>, val desc: String, val uri: String) {
    val id: UUID = UUID.randomUUID()

}

enum class Genre(val genre: String) {

    Drama("Drama"),
    Crime("Crime"),
    Action("Action"),
    WesternU("Western"),
    Adventure("Adventure")
}

data class Review(val message: String, val User: String, val rating: Double) {
    var id: UUID = UUID.randomUUID()

}
