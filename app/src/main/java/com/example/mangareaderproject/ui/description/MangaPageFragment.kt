package com.example.mangareaderproject.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mangareaderproject.data.Manga
import com.example.mangareaderproject.databinding.MangaPageFragmentBinding

class MangaPageFragment : Fragment() {
    private lateinit var manga: Manga
    private lateinit var binding: MangaPageFragmentBinding

    private lateinit var viewModel: MangaPageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            manga = it.getSerializable("manga") as Manga
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MangaPageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mangaCoverImage.setImageResource( manga.coverImageResourceId )
        binding.mangaDescriptionText.text = manga.description
        binding.mangaNameText.text = manga.name
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MangaPageViewModel::class.java]
    }

}