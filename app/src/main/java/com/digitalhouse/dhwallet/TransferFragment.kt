package com.digitalhouse.dhwallet


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.ContactAdapter
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType
import kotlin.jvm.internal.Intrinsics


class TransferFragment : Fragment(R.layout.fragment_transfer){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val profile = view.findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener{
            val intent = Intent(it.context, MinhaActivity::class.java)
            startActivity(intent)
        }

        val listContact = MutableList (10){
            Contact(
                type = ContactType.AMIGO,
                name = "Rick",
                image = "https://mixdeseries.com.br/wp-content/uploads/2021/07/rick-and-morty-s5-5-1.jpg"
            );

        }
        //testando
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ContactAdapter(listContact)

    }

}

