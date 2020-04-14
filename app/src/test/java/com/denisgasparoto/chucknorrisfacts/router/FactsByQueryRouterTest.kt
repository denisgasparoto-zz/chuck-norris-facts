package com.denisgasparoto.chucknorrisfacts.router

import com.denisgasparoto.chucknorrisfacts.base.BaseRouterTest
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryActivity
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryContract
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryRouter
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * @author Denis Gasparoto on 14/04/2020.
 */
class FactsByQueryRouterTest : BaseRouterTest<FactsByQueryContract.Router>() {

    override lateinit var router: FactsByQueryContract.Router

    private val activity = mockk<FactsByQueryActivity>(relaxed = true)

    override fun setupTest() {
        router = FactsByQueryRouter(activity)
    }

    @Test
    fun `route to share fact`() {
        router.routeToShareFact("https://www.google.com/")

        verify { activity.startActivity(any()) }
        confirmVerified(activity)
    }
}
