package com.denisgasparoto.chucknorrisfacts.presentation.splash

import android.content.Intent

/**
 * @author Denis Gasparoto on 30/03/2020.
 */
class SplashRouter(
    private val activity: SplashActivity
) : SplashContract.Router {

    override fun routeToFactsActivity() {
        activity.apply {
            startActivity(Intent())
            finish()
        }
    }
}
