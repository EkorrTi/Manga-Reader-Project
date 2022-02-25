package com.example.mangareaderproject.ui.main

import androidx.lifecycle.ViewModel
import com.example.mangareaderproject.R
import com.example.mangareaderproject.data.Manga

class MainViewModel : ViewModel() {
    val mangaList: List<Manga> = listOf(
            Manga("Chainsaw Man", "Young boy fuses with a demon", R.drawable.chainsaw_man),
            Manga("Mushihime", "New student is very sus", R.drawable.mushihime),
            Manga("Parasyte", "My right-hand talks now", R.drawable.parasyte),
            Manga("Parasyte", "", R.drawable.parasyte),
            Manga("Parasyte", "", R.drawable.parasyte),
            Manga("Parasyte", "", R.drawable.parasyte),
    )
}