package com.example.mangareaderproject.data.api

data class Relationship(
    val id: String,
    val type: String,
    val attributes: RelationshipAttribute?,
    val related: String?
)