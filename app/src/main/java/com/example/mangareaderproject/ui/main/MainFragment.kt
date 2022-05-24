package com.example.mangareaderproject.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mangareaderproject.R
import com.example.mangareaderproject.adapters.MangaListAdapter
import com.example.mangareaderproject.databinding.MainFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getFeed(viewModel.exampleIdsList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity?.findViewById<BottomNavigationView>(R.id.bottom_nav))?.visibility = View.VISIBLE

        binding.libraryRecyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)
        binding.libraryRecyclerView.setHasFixedSize(true)

        val adapter = MangaListAdapter()
        adapter.onClick = {
            val bundle = bundleOf( Pair("manga", it), Pair("name", it.attributes.title.en) )
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_mangaPageFragment, bundle)
        }
        binding.libraryRecyclerView.adapter = adapter

        viewModel.feedResponse.observe(viewLifecycleOwner){ response ->
            (binding.libraryRecyclerView.adapter as MangaListAdapter).data = response.mangaList
        }

        super.onViewCreated(view, savedInstanceState)
    }
}