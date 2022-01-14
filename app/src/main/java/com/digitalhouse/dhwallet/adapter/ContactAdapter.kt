package com.digitalhouse.dhwallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.GroupCompany
import com.digitalhouse.dhwallet.model.GroupContact
import com.digitalhouse.dhwallet.model.GroupType
import com.digitalhouse.dhwallet.util.ext.load

private const val HEADER = 0
private const val CONTENT = 1

class ContactAdapter(private val items: List<GroupContact>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        if (viewType == HEADER) {
        return HeaderViewHolder(inflater.inflate(R.layout.item_header_contact, parent ,false))
        }

        return ContactViewHolder(inflater.inflate(R.layout.item_contact, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ContactViewHolder -> holder.bind(items[position])
            is HeaderViewHolder -> holder.bindHeader(items[position].title ?: "teste")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].type == GroupType.TITLE){
            return HEADER
        }
        return CONTENT
    }

    override fun getItemCount() = items.size
}

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView = view.findViewById(R.id.header_contact_tittle)

    fun bindHeader(contactTitle: String){
        title.text = contactTitle
    }
}

class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val image: ImageView = view.findViewById(R.id.image)
    private val title: TextView = view.findViewById(R.id.item_contact_title)
    private val subtitle: TextView = view.findViewById(R.id.item_contact_subtitle)

    fun bind (item: GroupContact) {
        item.image?.let { image.load(it) }
        title.text = item.name
        subtitle.text = item.description
    }
}
