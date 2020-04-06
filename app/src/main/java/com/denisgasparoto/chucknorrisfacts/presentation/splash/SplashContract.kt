package com.denisgasparoto.chucknorrisfacts.presentation.splash

/**
 * @author Denis Gasparoto on 30/03/2020.
 */
interface SplashContract {

    interface ViewModel {
        fun initializeSplashTimer()
    }

    interface Router {
        fun routeToFactsActivity()
    }
}
