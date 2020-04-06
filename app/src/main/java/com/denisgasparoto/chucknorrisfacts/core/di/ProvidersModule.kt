package com.denisgasparoto.chucknorrisfacts.core.di

import com.denisgasparoto.chucknorrisfacts.core.base.AppSchedulerProvider
import com.denisgasparoto.chucknorrisfacts.core.base.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module

/**
 * @author Denis Gasparoto on 25/03/2020.
 */
internal val providersModule = module {
    single { CompositeDisposable() }
    single<SchedulerProvider> { AppSchedulerProvider() }
}
