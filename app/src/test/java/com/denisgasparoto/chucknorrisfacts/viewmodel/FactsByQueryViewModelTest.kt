package com.denisgasparoto.chucknorrisfacts.viewmodel

import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.base.BaseViewModelTest
import com.denisgasparoto.chucknorrisfacts.core.extensions.emptyString
import com.denisgasparoto.chucknorrisfacts.domain.model.display.FactsQueryResultDisplay
import com.denisgasparoto.chucknorrisfacts.domain.model.response.FactsQueryResultResponse
import com.denisgasparoto.chucknorrisfacts.domain.model.response.FactsQueryResultResponseItem
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryContract
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryViewModel
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.io.IOException

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
class FactsByQueryViewModelTest : BaseViewModelTest<FactsByQueryContract.ViewModel>() {

    override lateinit var viewModel: FactsByQueryViewModel

    private val interactor = mockk<FactsByQueryContract.Interactor>()
    private val router = mockk<FactsByQueryContract.Router>(relaxed = true)

    private val factsQueryResultResponseItem = FactsQueryResultResponseItem(
        categories = listOf("test"),
        createdAt = String.emptyString(),
        iconUrl = String.emptyString(),
        id = String.emptyString(),
        updatedAt = String.emptyString(),
        url = String.emptyString(),
        fact = String.emptyString()
    )
    private val factsQueryResultDisplay = FactsQueryResultDisplay(
        categories = listOf("test"),
        createdAt = String.emptyString(),
        iconUrl = String.emptyString(),
        id = String.emptyString(),
        updatedAt = String.emptyString(),
        url = String.emptyString(),
        fact = String.emptyString(),
        factLength = R.dimen.text_huge
    )
    private val factsQueryResultResponse = FactsQueryResultResponse(
        0, listOf(factsQueryResultResponseItem)
    )

    override fun initialize() {
        viewModel = FactsByQueryViewModel(
            router,
            interactor,
            compositeDisposable,
            schedulerProvider
        )
    }

    @Test
    fun `fill facts when fetch facts by query successfully`() {
        every { interactor.fetchFactsByQuery("dev") } returns Single.just(factsQueryResultResponse)

        viewModel.fetchFactsByQuery("dev")

        testScheduler.triggerActions()

        verify(exactly = 1) { interactor.fetchFactsByQuery("dev") }
        confirmVerified(interactor)

        assertEquals(viewModel.fillFactsByQuery().value, listOf(factsQueryResultDisplay))
    }

    @Test
    fun `show error when fetch facts by query error unsuccessfully`() {
        val error = IOException()
        val errorMessage = "Error message"

        every { interactor.fetchFactsByQuery("dev") } returns Single.error(error)
        every { interactor.getErrorMessage(error) } returns errorMessage

        viewModel.fetchFactsByQuery("dev")
        testScheduler.triggerActions()

        verify(exactly = 1) { interactor.fetchFactsByQuery("dev") }
        verify(exactly = 1) { interactor.getErrorMessage(error) }

        confirmVerified(interactor)

        assertEquals(viewModel.showError().value, errorMessage)
    }

    @Test
    fun `show error when query is empty`() {
        viewModel.fetchFactsByQuery(String.emptyString())
        assertEquals(
            viewModel.showInvalidSearchError().value,
            viewModel.showInvalidSearchError().value
        )
    }

    @Test
    fun `show error when query length is invalid`() {
        viewModel.fetchFactsByQuery("ab")
        assertEquals(
            viewModel.showInvalidSearchError().value,
            viewModel.showInvalidSearchError().value
        )
    }

    @Test
    fun `call route to share fact`() {
        viewModel.shareFact(factsQueryResultDisplay.url)
        verify { router.routeToShareFact(factsQueryResultDisplay.url) }
    }

    @Test
    fun `fill facts when fetch facts by query successfully and categories is null or empty`() {
        val factsQueryResultResponseItem = this.factsQueryResultResponseItem
        factsQueryResultResponseItem.categories = listOf()

        val factsQueryResultDisplay = FactsQueryResultDisplay(
            categories = listOf("UNCATEGORIZED"),
            createdAt = String.emptyString(),
            iconUrl = String.emptyString(),
            id = String.emptyString(),
            updatedAt = String.emptyString(),
            url = String.emptyString(),
            fact = String.emptyString(),
            factLength = R.dimen.text_huge
        )
        val factsQueryResultResponse = FactsQueryResultResponse(
            0, listOf(factsQueryResultResponseItem)
        )

        every { interactor.fetchFactsByQuery("dev") } returns Single.just(factsQueryResultResponse)

        viewModel.fetchFactsByQuery("dev")

        testScheduler.triggerActions()

        verify(exactly = 1) { interactor.fetchFactsByQuery("dev") }
        confirmVerified(interactor)

        assertEquals(viewModel.fillFactsByQuery().value, listOf(factsQueryResultDisplay))
    }

    @Test
    fun `fill facts when fetch facts by query successfully and set fact text length to normal size`() {
        val factsQueryResultResponseItem = FactsQueryResultResponseItem(
            categories = listOf("test"),
            createdAt = String.emptyString(),
            iconUrl = String.emptyString(),
            id = String.emptyString(),
            updatedAt = String.emptyString(),
            url = String.emptyString(),
            fact = "When Chuck Norris was in middle school, his English teacher assigned an essay..."
        )
        val factsQueryResultDisplay = FactsQueryResultDisplay(
            categories = listOf("test"),
            createdAt = String.emptyString(),
            iconUrl = String.emptyString(),
            id = String.emptyString(),
            updatedAt = String.emptyString(),
            url = String.emptyString(),
            fact = "When Chuck Norris was in middle school, his English teacher assigned an essay...",
            factLength = R.dimen.text_normal
        )
        val factsQueryResultResponse = FactsQueryResultResponse(
            0, listOf(factsQueryResultResponseItem)
        )

        every { interactor.fetchFactsByQuery("dev") } returns Single.just(factsQueryResultResponse)

        viewModel.fetchFactsByQuery("dev")

        testScheduler.triggerActions()

        verify(exactly = 1) { interactor.fetchFactsByQuery("dev") }
        confirmVerified(interactor)

        assertEquals(viewModel.fillFactsByQuery().value, listOf(factsQueryResultDisplay))
    }
}
