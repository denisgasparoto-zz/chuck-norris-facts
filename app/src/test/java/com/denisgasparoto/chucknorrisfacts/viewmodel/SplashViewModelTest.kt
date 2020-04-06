package com.denisgasparoto.chucknorrisfacts.viewmodel

import com.denisgasparoto.chucknorrisfacts.base.BaseViewModelTest
import com.denisgasparoto.chucknorrisfacts.presentation.splash.SplashContract
import com.denisgasparoto.chucknorrisfacts.presentation.splash.SplashViewModel
import io.mockk.confirmVerified
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * @author Denis Gasparoto on 05/04/2020.
 */
class SplashViewModelTest : BaseViewModelTest<SplashContract.ViewModel>() {

    override lateinit var viewModel: SplashContract.ViewModel

    private val router = mockk<SplashContract.Router>(relaxed = true)

    override fun initialize() {
        viewModel = SplashViewModel(
            router,
            compositeDisposable,
            schedulerProvider
        )
    }

    @Test
    fun `route to facts activity after delay`() {
        viewModel.initializeSplashTimer()
        testScheduler.advanceTimeBy(SPLASH_DELAY, TimeUnit.SECONDS)

        verify(exactly = 1) { router.routeToFactsActivity() }
        confirmVerified(router)
    }

    private companion object {
        private const val SPLASH_DELAY = 2L
    }
}
