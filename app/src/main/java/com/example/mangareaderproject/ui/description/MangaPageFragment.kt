package com.example.mangareaderproject.ui.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangareaderproject.adapters.ChapterListAdapter
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
        viewModel.getChapters(manga.manga_id)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MangaPageFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.chaptersList.adapter = ChapterListAdapter()

        viewModel.chapters.observe(viewLifecycleOwner) { list ->
            with(binding.chaptersList.adapter as ChapterListAdapter){
                this.data = list
                this.onClick = {
                    val action = MangaPageFragmentDirections.actionMangaPageFragmentToReaderFragment(chapterId = it.id)
                    findNavController().navigate(action)
                }
            }
        }

        binding.mangaCoverImage.setImageResource( manga.coverImageResourceId )

        val llm = LinearLayoutManager(requireContext())
        //llm.reverseLayout = true
        binding.chaptersList.layoutManager = llm

        viewModel.mangaResponse.observe(viewLifecycleOwner) {
            binding.mangaNameText.text = it.data.attributes.title.en
            binding.mangaDescriptionText.text = it.data.attributes.description.en
        }
    }
}