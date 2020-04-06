package com.denisgasparoto.chucknorrisfacts.core.network

import com.denisgasparoto.chucknorrisfacts.domain.model.response.FactsQueryResultResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Denis Gasparoto on 25/03/2020.
 */
interface ChuckNorrisService {

    @GET("search")
    fun fetchFacts(@Query("query") query: String): Single<FactsQueryResultResponse>
}
