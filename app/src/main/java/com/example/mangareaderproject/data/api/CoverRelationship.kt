package com.example.mangareaderproject.data.api

data class CoverRelationship(
    val id: String,
    val type: String,
    val attributes: CoverAttribute?,
    val related: String?
)