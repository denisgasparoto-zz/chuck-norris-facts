package com.denisgasparoto.chucknorrisfacts.domain.usecase

import com.denisgasparoto.chucknorrisfacts.core.network.ChuckNorrisService
import com.denisgasparoto.chucknorrisfacts.domain.model.response.FactsQueryResultResponse
import io.reactivex.Single

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
interface FetchFactsByQueryUseCase {
    fun fetchFactsByQuery(query: String): Single<FactsQueryResultResponse>
}

class FetchFactsByQueryUseCaseImpl(
    private val service: ChuckNorrisService
) : FetchFactsByQueryUseCase {

    override fun fetchFactsByQuery(query: String) = service.fetchFacts(query)
}


