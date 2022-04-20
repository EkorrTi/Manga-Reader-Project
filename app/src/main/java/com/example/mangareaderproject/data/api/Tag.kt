package com.example.mangareaderproject.data.api

data class Tag(
    val attributes: TagAttribute,
    val id: String,
    val relationships: List<Any>,
    val type: String
)