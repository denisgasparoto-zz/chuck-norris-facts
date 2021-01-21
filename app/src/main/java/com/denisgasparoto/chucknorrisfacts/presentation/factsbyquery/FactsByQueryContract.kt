package com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery

import androidx.lifecycle.MutableLiveData
import com.denisgasparoto.chucknorrisfacts.core.base.Resource
import com.denisgasparoto.chucknorrisfacts.domain.model.display.FactsQueryResultDisplay
import com.denisgasparoto.chucknorrisfacts.domain.usecase.FetchFactsByQueryUseCase
import com.denisgasparoto.chucknorrisfacts.domain.usecase.GetErrorMessageUseCase

/**
 * @author Denis Gasparoto on 01/04/2020.
 */
interface FactsByQueryContract {

    interface ViewModel {

        val factsQueryResultDisplay: MutableLiveData<Resource<List<FactsQueryResultDisplay>>>

        fun validateSearchQuery(query: String)

//        fun fetchFactsByQuery(query: String)

        fun shareFact(url: String)
    }

    interface Interactor : FetchFactsByQueryUseCase, GetErrorMessageUseCase

    interface Router {

        fun routeToShareFact(url: String)
    }
}
