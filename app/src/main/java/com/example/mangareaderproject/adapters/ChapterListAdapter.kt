package com.example.mangareaderproject.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mangareaderproject.R
import com.example.mangareaderproject.data.api.Chapter
import com.example.mangareaderproject.data.api.ScanlationGroupRelationship
import java.text.SimpleDateFormat

/**
 * Adapter for a List of Chapters
 */
class ChapterListAdapter : RecyclerView.Adapter<ChapterListAdapter.ChapterListViewHolder>() {
    var onClick: ((Chapter) -> Unit)? = null
    var data: List<Chapter> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.chapter_item, parent, false)

        return ChapterListViewHolder(adapterLayout)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ChapterListViewHolder, position: Int) {
        // Insert text for chapter number and title
        holder.chapterTitle.text = holder.itemView.resources.getString(
            R.string.chapter_title,
            data[position].attributes.chapter,
            data[position].attributes.title
        )

        // Get scanlation group if available
        val scanGroupRel: ScanlationGroupRelationship? =
            data[position].relationships.find { it.type == "scanlation_group" }
        var scanGroup = ""
        if (scanGroupRel != null)
            scanGroup = scanGroupRel.attributes.name

        // Insert text for chapter date and scanlation group
        holder.chapterExtra.text = holder.itemView.resources.getString(
            R.string.chapter_extra,
            SimpleDateFormat("dd/MM/yyyy").format(data[position].attributes.publishAt),
            scanGroup
        )


        holder.itemView.setOnClickListener { onClick?.invoke(data[position]) }
    }

    override fun getItemCount(): Int = data.size

    class ChapterListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chapterTitle: TextView = view.findViewById(R.id.chapter_title)
        val chapterExtra: TextView = view.findViewById(R.id.chapter_extra_info)
    }
}