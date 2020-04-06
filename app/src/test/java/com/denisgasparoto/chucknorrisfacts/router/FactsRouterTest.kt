package com.denisgasparoto.chucknorrisfacts.router

import com.denisgasparoto.chucknorrisfacts.base.BaseRouterTest
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsActivity
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsContract
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsRouter
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
class FactsRouterTest : BaseRouterTest<FactsContract.Router>() {

    override lateinit var router: FactsRouter

    private val activity = mockk<FactsActivity>(relaxed = true)

    override fun setupTest() {
        router = FactsRouter(activity)
    }

    @Test
    fun `route to facts by query activity`() {
        router.routeToFactsByQueryActivity()

        verify { activity.startActivity(any()) }
        confirmVerified(activity)
    }
}
