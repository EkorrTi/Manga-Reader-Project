package com.example.mangareaderproject.ui.description

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.mangareaderproject.R
import com.example.mangareaderproject.adapters.ChapterListAdapter
import com.example.mangareaderproject.data.api.Manga
import com.example.mangareaderproject.databinding.MangaPageFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MangaPageFragment : Fragment() {
    private lateinit var manga: Manga
    private lateinit var binding: MangaPageFragmentBinding

    private val viewModel: MangaPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { manga = it.getSerializable("manga") as Manga }
        viewModel.getChapters(manga.id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MangaPageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity?.findViewById<BottomNavigationView>(R.id.bottom_nav))?.visibility = View.GONE

        val adapter = ChapterListAdapter()
        adapter.onClick = {
            val bundle = bundleOf( Pair("chapter_id", it.id) )
            Navigation.findNavController(view).navigate(R.id.action_mangaPageFragment_to_readerFragment, bundle)
        }
        binding.chaptersList.adapter = adapter

        viewModel.chapters.observe(viewLifecycleOwner) { list ->
            (binding.chaptersList.adapter as ChapterListAdapter).data = list
            binding.chapterCount.text = getString(R.string.chapter_count, list.size)
        }

        val llm = LinearLayoutManager(requireContext())
        //llm.reverseLayout = true
        binding.chaptersList.layoutManager = llm


        binding.mangaNameText.text = manga.attributes.title.en
        binding.mangaDescriptionText.text = manga.attributes.description.en

        val coverUrl = "https://uploads.mangadex.org/covers/${manga.id}/${manga.relationships.first{ rel -> rel.type == "cover_art" }.attributes?.fileName}.256.jpg"
            // "https://uploads.mangadex.org/covers/{ manga.id }/{ cover.filename }.256.jpg"

        Log.i("coverUrl", coverUrl)
        binding.mangaCoverImage.load(coverUrl)
    }
}