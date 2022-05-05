package com.example.mangareaderproject.data.api

data class Manga(
    val attributes: MangaAttributes,
    val id: String,
    val relationships: List<CoverRelationship>,
    val type: String
)