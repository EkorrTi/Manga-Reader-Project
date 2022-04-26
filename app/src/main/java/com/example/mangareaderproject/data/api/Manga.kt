package com.example.mangareaderproject.data.api

data class Manga(
    val attributes: Attributes,
    val id: String,
    val relationships: List<CoverRelationship>,
    val type: String
)