package com.example.mangareaderproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mangareaderproject.R
import com.example.mangareaderproject.data.api.ApiAtHomeResponse
import com.example.mangareaderproject.data.api.ApiFeedResponse
import com.example.mangareaderproject.data.api.Chapter
import com.example.mangareaderproject.data.api.ChapterFiles

class ReaderListAdapter : RecyclerView.Adapter<ReaderListAdapter.ReaderListViewHolder>() {
    var data: List<String> = emptyList()
    lateinit var apiResponse: ApiAtHomeResponse

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReaderListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.reader_list_item, parent, false)
        return ReaderListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ReaderListViewHolder, position: Int) {
        Log.i("lost", "${apiResponse.baseUrl}/data-saver/${apiResponse.chapterFiles.hash}/${data[position]}")
        holder.coverImage.load("${apiResponse.baseUrl}/data-saver/${apiResponse.chapterFiles.hash}/${data[position]}")
    }

    override fun getItemCount(): Int = data.size

    class ReaderListViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val coverImage: ImageView = view.findViewById(R.id.reader_image)
    }
}