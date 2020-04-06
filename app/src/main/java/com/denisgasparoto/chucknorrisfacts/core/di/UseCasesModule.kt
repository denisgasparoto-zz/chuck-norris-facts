package com.denisgasparoto.chucknorrisfacts.core.di

import com.denisgasparoto.chucknorrisfacts.domain.usecase.FetchFactsByQueryUseCase
import com.denisgasparoto.chucknorrisfacts.domain.usecase.FetchFactsByQueryUseCaseImpl
import com.denisgasparoto.chucknorrisfacts.domain.usecase.GetErrorMessageUseCase
import com.denisgasparoto.chucknorrisfacts.domain.usecase.GetErrorMessageUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * @author Denis Gasparoto on 25/03/2020.
 */
internal val useCasesModule = module {
    single<FetchFactsByQueryUseCase> { FetchFactsByQueryUseCaseImpl(get()) }
    single<GetErrorMessageUseCase> { GetErrorMessageUseCaseImpl(androidContext()) }
}
