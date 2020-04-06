package com.denisgasparoto.chucknorrisfacts.presentation.splash

import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.core.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * @author Denis Gasparoto on 30/03/2020.
 */
class SplashActivity : BaseActivity() {

    override var layoutResId = R.layout.activity_splash

    private val viewModel: SplashContract.ViewModel by viewModel<SplashViewModel> {
        parametersOf(this)
    }

    override fun initialize() = viewModel.initializeSplashTimer()
}
