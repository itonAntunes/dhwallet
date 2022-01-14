package com.digitalhouse.dhwallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.GroupCompany
import com.digitalhouse.dhwallet.model.GroupCompanyType

private const val HEADER = 0
private const val CONTENT = 1


class CompanyAdapter(private val itemsCompany: List<GroupCompany>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CompanyViewHolder(inflater.inflate(R.layout.item_company, parent, false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CompanyViewHolder -> holder.bind(itemsCompany[position])
            is HeaderViewHolder -> holder.bindHeader(itemsCompany[position].title ?: "teste")
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (itemsCompany[position].type == GroupCompanyType.TITLE){
            return HEADER
        }
        return CONTENT
    }

    override fun getItemCount() = itemsCompany.size
}

class CompanyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val image: ImageView = view.findViewById(R.id.image_company)
    private val title: TextView = view.findViewById(R.id.item_company_title)
    private val subtitle: TextView = view.findViewById(R.id.item_company_subtitle)
    private val value: TextView = view.findViewById(R.id.value_company)

    fun bind(item: GroupCompany) {
        Glide.with(image.context).load(item.image).circleCrop().into(image)

        title.text = item.name
        subtitle.text = item.description
        value.text = item.value

    }
}