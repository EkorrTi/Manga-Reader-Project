package com.example.mangareaderproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareaderproject.R
import com.example.mangareaderproject.data.Manga
import com.example.mangareaderproject.ui.main.MainFragmentDirections

class MangaListAdapter(private val context: Context, private val dataset: List<Manga>) : RecyclerView.Adapter<MangaListAdapter.MangaListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.manga_list_item, parent, false)

        return MangaListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MangaListViewHolder, position: Int) {
        holder.coverImage.setImageResource( dataset[position].coverImageResourceId )
        holder.titleName.text = dataset[position].name
        holder.coverImage.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToMangaPageFragment(manga = dataset[position], name = dataset[position].name)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class MangaListViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val coverImage: ImageView = view.findViewById(R.id.list_cover_image)
        val titleName: TextView = view.findViewById(R.id.list_title_name)
    }
}