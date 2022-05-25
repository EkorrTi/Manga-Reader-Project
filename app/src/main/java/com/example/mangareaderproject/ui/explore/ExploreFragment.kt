package com.example.mangareaderproject.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mangareaderproject.MangaReaderProjectApplication
import com.example.mangareaderproject.R
import com.example.mangareaderproject.adapters.MangaListAdapter
import com.example.mangareaderproject.databinding.ExploreFragmentBinding

class ExploreFragment : Fragment() {
    private lateinit var binding: ExploreFragmentBinding
    private val viewModel: ExploreViewModel by activityViewModels{
        ExploreViewModelFactory(
            (activity?.application as MangaReaderProjectApplication).database.mangaDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.getFeed()
        binding = ExploreFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).supportActionBar?.title = "Explore"
        binding.exploreRecyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)
        binding.exploreRecyclerView.setHasFixedSize(true)

        val adapter = MangaListAdapter()
        adapter.libraryIds = viewModel.getLibrary().map { it.id }
        adapter.onClick = {
            val bundle = bundleOf( Pair("manga", it), Pair("name", it.attributes.title.en) )
            Navigation.findNavController(view).navigate(R.id.action_exploreFragment_to_mangaPageFragment, bundle)
        }
        binding.exploreRecyclerView.adapter = adapter

        viewModel.feedResponse.observe(viewLifecycleOwner){ response ->
            (binding.exploreRecyclerView.adapter as MangaListAdapter).data = response.mangaList
        }

        super.onViewCreated(view, savedInstanceState)
    }
}