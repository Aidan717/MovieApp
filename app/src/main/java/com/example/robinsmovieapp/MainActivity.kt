package com.example.robinsmovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

import com.example.robinsmovieapp.dbAccess.DbAccessMovie
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var movies = DbAccessMovie.getAll()
        movies.forEach {
            addButtonsByMovie(it.title, it.id)
        }

    }

    private fun addButtonsByMovie(name: String, id: UUID) {
        var btn = Button(this);
        btn.text = name
        val rl = findViewById(R.id.linLay) as LinearLayout
                rl.addView(btn)


        btn.setOnClickListener{
            val intent = Intent(this, DetailedView::class.java)
            startActivity(intent.putExtra("getId", id.toString()))
        }
    }


//    class CustomAdapter(private val dataSet: MutableList<String>) :
//        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//
//        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            val textView: TextView
//
//            init {
//                textView = view.findViewById(R.id.button7)
//            }
//        }
//
//        // Create new views (invoked by the layout manager)
//        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//            // Create a new view, which defines the UI of the list item
//            val view = LayoutInflater.from(viewGroup.context)
//                .inflate(R.layout.activity_shawshank_redemption, viewGroup, false)
//
//            return ViewHolder(view)
//        }
//
//        // Replace the contents of a view (invoked by the layout manager)
//        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//
//            // Get element from your dataset at this position and replace the
//            // contents of the view with that element
//            viewHolder.textView.text = dataSet[position]
//        }
//
//        // Return the size of your dataset (invoked by the layout manager)
//        override fun getItemCount() = dataSet.size
//
//
//    }
}


