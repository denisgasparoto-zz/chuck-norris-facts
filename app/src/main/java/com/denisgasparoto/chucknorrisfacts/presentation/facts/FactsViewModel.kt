package com.denisgasparoto.chucknorrisfacts.presentation.facts

import com.denisgasparoto.chucknorrisfacts.core.base.BaseViewModel

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
class FactsViewModel(
    private val router: FactsContract.Router
) : BaseViewModel(), FactsContract.ViewModel {

    override fun callRouteToFactsByQueryActivity() = router.routeToFactsByQueryActivity()
}
