package com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery

import com.denisgasparoto.chucknorrisfacts.domain.usecase.GetErrorMessageUseCase
import com.denisgasparoto.chucknorrisfacts.domain.usecase.FetchFactsByQueryUseCase

/**
 * @author Denis Gasparoto on 01/04/2020.
 */
class FactsByQueryInteractor(
    private val fetchFactsByQueryUseCase: FetchFactsByQueryUseCase,
    private val getErrorMessageUseCase: GetErrorMessageUseCase
) : FactsByQueryContract.Interactor {

    override fun fetchFactsByQuery(query: String) =
        fetchFactsByQueryUseCase.fetchFactsByQuery(query)

    override fun getErrorMessage(error: Throwable) =
        getErrorMessageUseCase.getErrorMessage(error)
}
