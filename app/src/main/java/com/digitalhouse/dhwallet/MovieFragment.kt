package com.digitalhouse.dhwallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.digitalhouse.dhwallet.adapter.MovieAdapter
import com.digitalhouse.dhwallet.model.Movie

class MovieFragment : Fragment(R.layout.fragment_movie){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMovie = listOf<Movie>(
            Movie(
                "https://m.media-amazon.com/images/I/91MJHdDvZAL._AC_SY741_.jpg",
                "Game Of thrones",
                "Aventuras em Westerous"
            ),
            Movie(
                "https://www.ofuxico.com.br/wp-content/uploads/2021/12/Harry-Potter-foto.jpg",
                "Harry Potter",
                "Aventuras do pequeno Bruxo!"
            ),
            Movie(
                "https://br.web.img3.acsta.net/pictures/19/11/29/17/57/5161763.jpg",
                "The Witcher",
                "Aventuras do grande Bruxo"
            ),
            Movie(
                "https://revistabula.com/wp/wp-content/uploads/2020/08/homem-aranha.jpg",
                "Homem-Aranha",
                "Aventuras do Peter Parcker"
            )
        )


        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_movie)
        recyclerView.adapter = MovieAdapter(listMovie)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


    }

}