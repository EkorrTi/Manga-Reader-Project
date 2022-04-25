package com.example.mangareaderproject.data.api

data class Volume(
    val volume: String,
    val count: Int,
    val chapters: HashMap<String, Chapter>
)
