package com.digitalhouse.dhwallet


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.ContactAdapter
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType
import com.digitalhouse.dhwallet.model.GroupContact
import com.digitalhouse.dhwallet.model.GroupType
import kotlin.jvm.internal.Intrinsics


class TransferFragment : Fragment(R.layout.fragment_transfer){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val profile = view.findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {
            val intent = Intent(it.context, MainActivity::class.java)
            startActivity(intent)
        }

        val listContact = listOf<GroupContact>(
            GroupContact(
                type = GroupType.TITLE,
                title = "Rick",
                image = "https://mixdeseries.com.br/wp-content/uploads/2021/07/rick-and-morty-s5-5-1.jpg",
                contactType = ContactType.AMIGO
            ),

            GroupContact(
                type = GroupType.CONTENT,
                name = "Morty",
                image = "https://epipoca.com.br/wp-content/uploads/2021/02/rick-and-morty-1200x900.jpg",
                contactType = ContactType.IRMAO
            ),

            GroupContact(
                type = GroupType.CONTENT,
                name = "Morty",
                image = "https://epipoca.com.br/wp-content/uploads/2021/02/rick-and-morty-1200x900.jpg",
                contactType = ContactType.IRMAO
            ),

            GroupContact(
                type = GroupType.TITLE,
                title = "Rick",
                image = "https://mixdeseries.com.br/wp-content/uploads/2021/07/rick-and-morty-s5-5-1.jpg",
                contactType = ContactType.AMIGO
            ),
        )
        //testando
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_transfer)
        recyclerView.adapter = ContactAdapter(listContact)

    }

}

