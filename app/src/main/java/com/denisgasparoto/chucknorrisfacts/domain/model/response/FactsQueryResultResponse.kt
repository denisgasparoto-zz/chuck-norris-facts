package com.denisgasparoto.chucknorrisfacts.domain.model.response

import com.squareup.moshi.Json

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
data class FactsQueryResultResponse(
    val total: Int,
    @Json(name = "result") val facts: List<FactsQueryResultResponseItem>
)
