package com.denisgasparoto.chucknorrisfacts.presentation.splash

import com.denisgasparoto.chucknorrisfacts.core.base.BaseViewModel
import com.denisgasparoto.chucknorrisfacts.core.base.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

/**
 * @author Denis Gasparoto on 30/03/2020.
 */
class SplashViewModel(
    private val router: SplashContract.Router,
    private val compositeDisposable: CompositeDisposable,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel(), SplashContract.ViewModel {

    override fun initializeSplashTimer() {
        compositeDisposable.add(
            Observable.timer(SPLASH_DELAY, TimeUnit.SECONDS)
                .observeOn(schedulerProvider.computation)
                .subscribe { router.routeToFactsActivity() }
        )
    }

    private companion object {
        private const val SPLASH_DELAY = 2L
    }
}
