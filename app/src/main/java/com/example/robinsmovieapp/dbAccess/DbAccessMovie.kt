package com.example.robinsmovieapp.dbAccess

import com.example.robinsmovieapp.model.Genre
import com.example.robinsmovieapp.model.Movie
import com.example.robinsmovieapp.model.Review
import java.util.*



class DbAccessMovie {

    companion object {
        @Volatile
        @JvmStatic
        private var INSTANCE: DbAccessMovie? = null

        @JvmStatic
        @JvmOverloads
        fun getInstance(name: String = "default", temp: Double = 0.0): DbAccessMovie =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: DbAccessMovie().also { INSTANCE = it }
            }


        var movies: MutableList<Movie> = mutableListOf(

            Movie("The Shawshank Redemption", Genre.Drama, "14-10-1994", mutableListOf<Review>(), "this is a description for the detailed page of the movie you selected!", "@drawable/shawshank"),
            Movie("The Godfather", Genre.Crime, "19-3-1972", mutableListOf<Review>(), "this is a description for the detailed page of the movie you selected!", "@drawable/godfather"),
            Movie("The Godfather: Part II", Genre.Drama, "18-12-1974", mutableListOf<Review>(), "this is a description for the detailed page of the movie you selected!", "@drawable/godfather2")
        )

        fun addReviewById(id: UUID, review: Review) {
            var movie = getById(id)
            if(movie != null) {
                movie.reviews.add(review)
            }
        }

        fun addToList() {
            TODO()
        }

        fun removeFromList() {
            TODO()
        }

        fun getAll(): MutableList<Movie> {
            return movies;
        }

        fun searchByName() {
            TODO()
        }

        fun getById(id: UUID): Movie? {

        var movie: Movie? = null

            movies.forEach {

                if (it.id == id) {
                    movie = it
                }

            }
            return movie
        }
    }
}