package com.digitalhouse.dhwallet.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.Movie
import com.digitalhouse.dhwallet.util.ext.load

class MovieAdapte(private val filmes: List<Movie>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MovieViewHolder).bind(filmes[position])

    }

    override fun getItemCount() = filmes.size


}

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val image: ImageView = view.findViewById<ImageView>(R.id.item_movie_image)
    private val title: TextView = view.findViewById<TextView>(R.id.item_movie_title)
    private val description: TextView = view.findViewById<TextView>(R.id.item_movie_description)

    fun bind(filme: Movie){
        image.load(filme.image)
        title.text = filme.name
        description.text = filme.description



    }
}
