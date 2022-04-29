package com.example.mangareaderproject.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mangareaderproject.adapters.MangaListAdapter
import com.example.mangareaderproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = GridLayoutManager(this.requireContext(), 2)
        binding.recyclerView.setHasFixedSize(true)

        val adapter = MangaListAdapter(viewModel.mangaList)
        adapter.onClick = {
            val action = MainFragmentDirections.actionMainFragmentToMangaPageFragment(
                manga = it,
                name = it.name
            )
            findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter

        super.onViewCreated(view, savedInstanceState)
    }
}