package com.denisgasparoto.chucknorrisfacts.presentation.factsbyquery

import androidx.lifecycle.MutableLiveData
import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.core.base.BaseViewModel
import com.denisgasparoto.chucknorrisfacts.core.base.SchedulerProvider
import com.denisgasparoto.chucknorrisfacts.domain.model.display.FactsQueryResultDisplay
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * @author Denis Gasparoto on 01/04/2020.
 */
class FactsByQueryViewModel(
    private val router: FactsByQueryContract.Router,
    private val interactor: FactsByQueryContract.Interactor,
    private val compositeDisposable: CompositeDisposable,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel(), FactsByQueryContract.ViewModel {

    private val factsByQuery = MutableLiveData<List<FactsQueryResultDisplay>>()
    private var isLoading = MutableLiveData<Boolean>()
    private val error = MutableLiveData<String>()
    private val invalidSearchError = MutableLiveData<Int>()

    override fun fetchFactsByQuery(query: String) {
        if (query.isEmpty() || query.length < MINIMUM_QUERY_LENGTH) {
            invalidSearchError.postValue(R.string.invalid_search_message_error)
            Timber.d(TIMBER_INVALID_SEARCH_MESSAGE)
            return
        }

        compositeDisposable.add(
            interactor.fetchFactsByQuery(query)
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
                .doOnSubscribe { isLoading.value = true }
                .doAfterTerminate { isLoading.value = false }
                .subscribe(
                    { response ->
                        factsByQuery.postValue(
                            response.facts.map {
                                FactsQueryResultDisplay(
                                    categories = if (it.categories.isNullOrEmpty()) listOf(
                                        UNCATEGORIZED_LABEL
                                    ) else it.categories,
                                    createdAt = it.createdAt,
                                    iconUrl = it.iconUrl,
                                    id = it.id,
                                    updatedAt = it.updatedAt,
                                    url = it.url,
                                    fact = it.fact,
                                    factLength = if (it.fact.length >= FACT_LENGTH_TEXT_SIZE_MANAGER) R.dimen.text_normal else R.dimen.text_huge
                                )
                            }
                        )
                        Timber.d(TIMBER_RESPONSE_SUCCESS_MESSAGE)
                    }, {
                        error.postValue(interactor.getErrorMessage(it))
                        Timber.d(TIMBER_RESPONSE_ERROR_MESSAGE)
                    }
                )
        )
    }

    override fun fillFactsByQuery() = factsByQuery

    override fun shareFact(url: String) = router.routeToShareFact(url)

    override fun isLoading() = isLoading

    override fun showError() = error

    override fun showInvalidSearchError() = invalidSearchError

    private companion object {
        private const val UNCATEGORIZED_LABEL = "UNCATEGORIZED"
        private const val MINIMUM_QUERY_LENGTH = 3
        private const val FACT_LENGTH_TEXT_SIZE_MANAGER = 80
        private const val TIMBER_RESPONSE_SUCCESS_MESSAGE = "fetchFactsByQuery returns SUCCESS"
        private const val TIMBER_RESPONSE_ERROR_MESSAGE = "fetchFactsByQuery returns ERROR"
        private const val TIMBER_INVALID_SEARCH_MESSAGE = "empty or invalid search"
    }
}
