package com.example.mangareaderproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareaderproject.R

class MangaListAdapter(private val context: Context, private val dataset: List<String>) : RecyclerView.Adapter<MangaListAdapter.MangaListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.manga_list_item, parent, false)

        return MangaListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MangaListViewHolder, position: Int) {
        holder.titleName.text = dataset[position]
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class MangaListViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val titleName: TextView = view.findViewById(R.id.list_title_name)
    }
}