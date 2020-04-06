package com.denisgasparoto.chucknorrisfacts.domain.model.response

import com.squareup.moshi.Json

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
data class FactsQueryResultResponseItem(
    var categories: List<String>?,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "icon_url") val iconUrl: String,
    val id: String,
    @Json(name = "updated_at") val updatedAt: String,
    val url: String,
    @Json(name = "value") val fact: String
)
