package com.example.mangareaderproject.ui.main

import androidx.lifecycle.ViewModel
import com.example.mangareaderproject.R
import com.example.mangareaderproject.data.MangaBare

class MainViewModel : ViewModel() {
    val mangaList: List<MangaBare> = listOf(
            MangaBare("Chainsaw Man", "Young boy fuses with a demon", R.drawable.sample_image1, "a77742b1-befd-49a4-bff5-1ad4e6b0ef7b"),
            MangaBare("Mushihime", "New student is very sus", R.drawable.sample_image2, "91b9f2f0-e63f-4444-b1b4-552e167e089a"),
            MangaBare("Parasyte", "My right-hand talks now", R.drawable.sample_image3, "07823fcd-f2c9-458c-9824-3eae62b2a006"),
//            MangaBare("Parasyte", "", R.drawable.sample_image3),
//            MangaBare("Parasyte", "", R.drawable.sample_image3),
//            MangaBare("Hentai", "Some Hentai", R.drawable.sample_image3),
    )
}