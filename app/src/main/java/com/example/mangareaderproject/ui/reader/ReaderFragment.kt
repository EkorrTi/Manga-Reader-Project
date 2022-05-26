package com.example.mangareaderproject.ui.reader

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangareaderproject.adapters.MangaListAdapter
import com.example.mangareaderproject.adapters.ReaderListAdapter
import com.example.mangareaderproject.databinding.ReaderFragmentBinding

class ReaderFragment : Fragment() {
    private lateinit var binding: ReaderFragmentBinding
    private lateinit var chapterID: String

    // Send a get here https://api.mangadex.org/at-home/server/c90cdc8a-e27e-4d20-9855-d2c79ca0eebb
    // and see the response for the parameters
    // url pattern = { baseUrl }/data-saver/{ hash }/{ data[0] <- list item }

    private val viewModel: ReaderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { chapterID = it.getString("chapter_id").toString() }
        viewModel.getChapterData(chapterID)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = ReaderFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.readerFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = ReaderListAdapter()

        binding.readerFragmentRecyclerView.adapter = adapter


        Log.i("Mangadex reader chapter id", chapterID)


        viewModel.response.observe(viewLifecycleOwner) {
                response ->
            Log.i("lost", response.toString())
            (binding.readerFragmentRecyclerView.adapter as ReaderListAdapter).apiResponse = response
            (binding.readerFragmentRecyclerView.adapter as ReaderListAdapter).data = response.chapterFiles.dataSaver
            (binding.readerFragmentRecyclerView.adapter as ReaderListAdapter).notifyDataSetChanged()
        }

        super.onViewCreated(view, savedInstanceState)
    }
}