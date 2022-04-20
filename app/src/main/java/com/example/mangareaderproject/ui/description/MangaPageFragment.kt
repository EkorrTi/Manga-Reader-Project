package com.example.mangareaderproject.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mangareaderproject.data.MangaBare
import com.example.mangareaderproject.databinding.MangaPageFragmentBinding

class MangaPageFragment : Fragment() {
    private lateinit var manga: MangaBare
    private lateinit var binding: MangaPageFragmentBinding

    private val viewModel: MangaPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            manga = it.getSerializable("manga") as MangaBare
        }

        viewModel.getManga(manga.manga_id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MangaPageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mangaCoverImage.setImageResource( manga.coverImageResourceId )

        viewModel.response.observe(viewLifecycleOwner,{
            binding.mangaNameText.text = it.data.attributes.title.en
            binding.mangaDescriptionText.text = it.data.attributes.description.en
        })

        viewModel.status.observe(viewLifecycleOwner, {
            binding.statusText.text = it
        })
    }
}