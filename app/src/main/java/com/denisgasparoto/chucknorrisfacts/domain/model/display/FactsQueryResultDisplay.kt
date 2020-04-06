package com.denisgasparoto.chucknorrisfacts.domain.model.display

/**
 * @author Denis Gasparoto on 29/03/2020.
 */
data class FactsQueryResultDisplay(
    val categories: List<String>?,
    val createdAt: String,
    val iconUrl: String,
    val id: String,
    val updatedAt: String,
    val url: String,
    val fact: String,
    val factLength: Int
)
