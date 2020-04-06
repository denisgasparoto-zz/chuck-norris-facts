package com.denisgasparoto.chucknorrisfacts.core.di

import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsActivity
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsRouter
import com.denisgasparoto.chucknorrisfacts.presentation.facts.FactsViewModel
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryActivity
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryInteractor
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryRouter
import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryViewModel
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

    viewModel { (activity: FactsActivity) ->
        FactsViewModel(
            FactsRouter(activity)
        )
    }

    viewModel { (activity: FactsByQueryActivity) ->
        FactsByQueryViewModel(
            FactsByQueryRouter(activity),
            FactsByQueryInteractor(get(), get()),
            get(),
            get()
        )
    }
}
