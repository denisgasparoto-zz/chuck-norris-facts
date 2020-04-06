package com.denisgasparoto.chucknorrisfacts.usecase

import com.denisgasparoto.chucknorrisfacts.base.BaseUseCaseTest
import com.denisgasparoto.chucknorrisfacts.core.extensions.emptyString
import com.denisgasparoto.chucknorrisfacts.core.network.ChuckNorrisService
import com.denisgasparoto.chucknorrisfacts.domain.model.response.FactsQueryResultResponse
import com.denisgasparoto.chucknorrisfacts.domain.model.response.FactsQueryResultResponseItem
import com.denisgasparoto.chucknorrisfacts.domain.usecase.FetchFactsByQueryUseCase
import com.denisgasparoto.chucknorrisfacts.domain.usecase.FetchFactsByQueryUseCaseImpl
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
class FetchFactsByQueryUseCaseTest : BaseUseCaseTest<FetchFactsByQueryUseCase>() {

    override lateinit var useCase: FetchFactsByQueryUseCase

    private val service = mockk<ChuckNorrisService>(relaxed = true)

    override fun setupTest() {
        useCase = FetchFactsByQueryUseCaseImpl(service)
    }

    @Test
    fun `fetch facts and then return response`() {
        val factsQueryResultResponseItem = FactsQueryResultResponseItem(
            categories = listOf(),
            createdAt = String.emptyString(),
            iconUrl = String.emptyString(),
            id = String.emptyString(),
            updatedAt = String.emptyString(),
            url = String.emptyString(),
            fact = String.emptyString()
        )
        val factsQueryResultResponse = FactsQueryResultResponse(
            0, listOf(factsQueryResultResponseItem)
        )

        every { service.fetchFacts(QUERY_SEARCH) } returns Single.just(factsQueryResultResponse)

        useCase
            .fetchFactsByQuery(QUERY_SEARCH)
            .test()
            .assertResult(factsQueryResultResponse)
            .assertNoErrors()

        verify(exactly = 1) { service.fetchFacts(QUERY_SEARCH) }
        confirmVerified(service)
    }

    private companion object {
        private const val QUERY_SEARCH = "dev"

    }
}
