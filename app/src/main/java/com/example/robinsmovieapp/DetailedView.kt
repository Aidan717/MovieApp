package com.example.robinsmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.robinsmovieapp.dbAccess.DbAccessMovie
import com.example.robinsmovieapp.model.Review
import java.util.*

class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        //Gets to movie ID (UUID) to search for specific movie.
        var id = UUID.fromString(intent.getStringExtra("getId"))

        //Uses ID to return the right movie. Currently no try/catch safety
        var movie = DbAccessMovie.getById(id)


        //Variables for the different view objects
        var movieTitle = findViewById(R.id.movieTitle) as TextView
        var desc = findViewById(R.id.description) as TextView
        var genre = findViewById(R.id.genre) as TextView
        var image = findViewById(R.id.imageView) as ImageView
        var date = findViewById(R.id.date) as TextView

        var user = findViewById(R.id.user) as TextView
        var review = findViewById(R.id.review) as TextView
        var rating = findViewById(R.id.ratingBar) as RatingBar

        //Sets value of the different views, using the movie variables.
        if (movie != null) {
            movieTitle.text = movie.title
            genre.text = movie.genre.toString()
            desc.text = movie.desc
            date.text = movie.releaseDate.toString()

            var imageResource = getResources().getIdentifier(movie.uri, null, this.getPackageName());
            image.setImageResource(imageResource)
        }

       

        var btn = findViewById(R.id.button) as Button


        btn.setOnClickListener{

            var newReview = Review(review.toString(), user.toString(), rating.rating.toDouble())
            if (movie != null) {
                DbAccessMovie.addReviewById(movie.id, newReview)

                user.text = ""
                review.text = ""
                rating.rating = 0.0f
            }
        }
    }
}