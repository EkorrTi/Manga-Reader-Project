package com.example.mangareaderproject.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mangareaderproject.R

class MangaPage : Fragment() {

    companion object { fun newInstance() = MangaPage() }

    private lateinit var viewModel: MangaPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.manga_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MangaPageViewModel::class.java]
        // TODO: Use the ViewModel
    }

}