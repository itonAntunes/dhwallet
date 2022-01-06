package com.digitalhouse.dhwallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.Company

class CompanyAdapter(private val items: List<Company>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CompanyViewHolder(inflater.inflate(R.layout.item_company, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CompanyViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size
}

class CompanyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val image: ImageView = view.findViewById(R.id.image_company)
    private val title: TextView = view.findViewById(R.id.item_company_title)
    private val subtitle: TextView = view.findViewById(R.id.item_company_subtitle)
    private val value: TextView = view.findViewById(R.id.value_company)

    fun bind (item: Company) {
        Glide.with(image.context).load(item.image).circleCrop().into(image)

        title.text = item.name
        subtitle.text = item.type.description
        value.text = item.valueCompany

    }
}