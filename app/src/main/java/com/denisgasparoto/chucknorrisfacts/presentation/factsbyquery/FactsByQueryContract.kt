package com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery

import androidx.lifecycle.LiveData
import com.denisgasparoto.chucknorrisfacts.domain.model.display.FactsQueryResultDisplay
import com.denisgasparoto.chucknorrisfacts.domain.usecase.FetchFactsByQueryUseCase
import com.denisgasparoto.chucknorrisfacts.domain.usecase.GetErrorMessageUseCase

/**
 * @author Denis Gasparoto on 01/04/2020.
 */
interface FactsByQueryContract {

    interface ViewModel {

        fun fetchFactsByQuery(query: String)

        fun fillFactsByQuery(): LiveData<List<FactsQueryResultDisplay>>

        fun shareFact(url: String)

        fun isLoading(): LiveData<Boolean>

        fun showError(): LiveData<String>

        fun showInvalidSearchError(): LiveData<Int>
    }

    interface Interactor : FetchFactsByQueryUseCase, GetErrorMessageUseCase

    interface Router {

        fun routeToShareFact(url: String)
    }
}
