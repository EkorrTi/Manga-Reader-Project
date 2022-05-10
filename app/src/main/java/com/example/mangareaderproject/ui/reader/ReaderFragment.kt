package com.example.mangareaderproject.ui.reader

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mangareaderproject.databinding.ReaderFragmentBinding

class ReaderFragment : Fragment() {
    private lateinit var binding: ReaderFragmentBinding
    private lateinit var chapterID: String

    // Send a get here https://api.mangadex.org/at-home/server/c90cdc8a-e27e-4d20-9855-d2c79ca0eebb
    // and see the response for the parameters
    // url pattern = { baseUrl }/data-saver/{ hash }/{ data[0] <- list item }

    private val viewModel: ReaderViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = ReaderFragmentBinding.inflate(layoutInflater)

        arguments?.let {
            chapterID = it.getString("chapter_id", "")
        }
        Log.i("Mangadex reader chapter id", chapterID)

        viewModel.getChapterData(chapterID)
        viewModel.response.observe(viewLifecycleOwner) {
            // Do something
        }
        return binding.root
    }
}