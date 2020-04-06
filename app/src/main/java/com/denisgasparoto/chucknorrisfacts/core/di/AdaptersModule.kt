package com.denisgasparoto.chucknorrisfacts.core.di

import com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery.FactsByQueryAdapter
import org.koin.dsl.module

/**
 * @author Denis Gasparoto on 28/03/2020.
 */
internal val adaptersModule = module {
    single { FactsByQueryAdapter() }
}
