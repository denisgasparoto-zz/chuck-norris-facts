package com.denisgasparoto.chucknorrisfacts.presentation.facts

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
interface FactsContract {

    interface ViewModel {

        fun callRouteToFactsByQueryActivity()
    }

    interface Router {

        fun routeToFactsByQueryActivity()
    }
}
