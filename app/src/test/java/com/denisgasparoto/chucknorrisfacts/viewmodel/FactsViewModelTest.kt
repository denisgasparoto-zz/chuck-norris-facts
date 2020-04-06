package com.denisgasparoto.chucknorrisfacts.viewmodel

import com.denisgasparoto.chucknorrisfacts.base.BaseViewModelTest
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsContract
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsViewModel
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * @author Denis Gasparoto on 05/04/2020.
 */
class FactsViewModelTest : BaseViewModelTest<FactsContract.ViewModel>() {

    override lateinit var viewModel: FactsContract.ViewModel

    private val router = mockk<FactsContract.Router>(relaxed = true)

    override fun initialize() {
        viewModel = FactsViewModel(router)
    }

    @Test
    fun `route to facts by query activity`() {
        viewModel.callRouteToFactsByQueryActivity()

        verify(exactly = 1) { router.routeToFactsByQueryActivity() }
        confirmVerified(router)
    }
}
