package com.denisgasparoto.chucknorrisfacts.core.di

import com.denisgasparoto.chucknorrisfacts.presentation.splash.SplashActivity
import com.denisgasparoto.chucknorrisfacts.presentation.splash.SplashRouter
import com.denisgasparoto.chucknorrisfacts.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Denis Gasparoto on 27/03/2020.
 */
internal val viewModelsModule = module {
    viewModel { (activity: SplashActivity) ->
        SplashViewModel(
            SplashRouter(activity),
            get(),
            get()
        )
    }
}
