package com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery

import android.content.Intent

/**
 * @author Denis Gasparoto on 01/04/2020.
 */
class FactsByQueryRouter(
    private val activity: FactsByQueryActivity
) : FactsByQueryContract.Router {

    override fun routeToShareFact(url: String) =
        activity.startActivity(
            Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, url)
                type = INTENT_TYPE
            }, null)
        )

    companion object {

        private const val INTENT_TYPE = "text/plain"
    }
}
