package com.denisgasparoto.chucknorrisfacts.presentation.facts

import android.app.Activity
import android.content.Intent

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
class FactsRouter(
    private val activity: FactsActivity
) : FactsContract.Router {

    override fun routeToFactsByQueryActivity() =
        activity.startActivity(Intent(activity, Activity::class.java))
}
