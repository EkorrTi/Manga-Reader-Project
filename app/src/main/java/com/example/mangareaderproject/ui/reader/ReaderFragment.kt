package com.example.mangareaderproject.ui.reader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mangareaderproject.databinding.ReaderFragmentBinding

class ReaderFragment : Fragment() {
    private lateinit var binding: ReaderFragmentBinding

    private val viewModel: ReaderViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = ReaderFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}