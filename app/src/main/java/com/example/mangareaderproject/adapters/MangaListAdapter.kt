package com.example.mangareaderproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareaderproject.R
import com.example.mangareaderproject.data.MangaBare

class MangaListAdapter(private val data: List<MangaBare>) : RecyclerView.Adapter<MangaListAdapter.MangaListViewHolder>() {

    var onClick:((MangaBare) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.manga_list_item, parent, false)

        return MangaListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MangaListViewHolder, position: Int) {
        holder.coverImage.setImageResource( data[position].coverImageResourceId )
        holder.titleName.text = data[position].name
        holder.coverImage.setOnClickListener { onClick?.invoke(data[position]) }
    }

    override fun getItemCount(): Int = data.size

    class MangaListViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val coverImage: ImageView = view.findViewById(R.id.list_cover_image)
        val titleName: TextView = view.findViewById(R.id.list_title_name)
    }
}