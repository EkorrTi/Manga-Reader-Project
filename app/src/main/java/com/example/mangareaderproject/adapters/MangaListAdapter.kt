package com.example.mangareaderproject.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mangareaderproject.R
import com.example.mangareaderproject.data.api.Manga

class MangaListAdapter : RecyclerView.Adapter<MangaListAdapter.MangaListViewHolder>() {

    var onClick:((Manga) -> Unit)? = null
    var data: List<Manga> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var libraryIds: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.manga_list_item, parent, false)

        return MangaListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: MangaListViewHolder, position: Int) {
        holder.coverImage.load("https://uploads.mangadex.org/covers/${data[position].id}/${data[position].relationships.first{ rel -> rel.type == "cover_art" }.attributes?.fileName}.256.jpg")
        if (data[position].id in libraryIds) {
            Log.i("Manga in library", "${data[position].attributes.title.en} factual, library = $libraryIds")
            holder.coverImage.foreground = ResourcesCompat.getDrawable(
                holder.itemView.resources,
                R.drawable.in_library_gradient,
                null
            )
        } else { holder.coverImage.foreground = null }
        holder.titleName.text = data[position].attributes.title.en
        holder.coverImage.setOnClickListener { onClick?.invoke(data[position]) }
    }

    override fun getItemCount(): Int = data.size

    class MangaListViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val coverImage: ImageView = view.findViewById(R.id.list_cover_image)
        val titleName: TextView = view.findViewById(R.id.list_title_name)
    }
}