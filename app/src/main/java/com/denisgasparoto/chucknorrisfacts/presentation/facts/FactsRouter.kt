package com.denisgasparoto.chucknorrisfacts.presentation.facts

import android.content.Intent
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryActivity

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
class FactsRouter(
    private val activity: FactsActivity
) : FactsContract.Router {

    override fun routeToFactsByQueryActivity() =
        activity.startActivity(Intent(activity, FactsByQueryActivity::class.java))
}
