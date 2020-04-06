package com.denisgasparoto.chucknorrisfacts.router

import com.denisgasparoto.chucknorrisfacts.presentation.splash.SplashActivity
import com.denisgasparoto.chucknorrisfacts.presentation.splash.SplashRouter
import com.denisgasparoto.chucknorrisfacts.base.BaseRouterTest
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
class SplashRouterTest : BaseRouterTest<SplashRouter>() {

    override lateinit var router: SplashRouter

    private val activity = mockk<SplashActivity>(relaxed = true)

    override fun setupTest() {
        router = SplashRouter(activity)
    }

    @Test
    fun `route to facts activity and finish splash activity`() {
        router.routeToFactsActivity()

        verify { activity.startActivity(any()) }
        verify { activity.finish() }

        confirmVerified(activity)
    }
}
