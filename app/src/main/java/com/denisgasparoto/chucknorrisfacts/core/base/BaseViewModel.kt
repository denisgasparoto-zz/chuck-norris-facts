package com.denisgasparoto.chucknorrisfacts.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Denis Gasparoto on 28/03/2020.
 */
abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    protected fun <T> MutableLiveData<Resource<T>>.success(data: T?) {
        postValue(Resource.success(data))
    }

    protected fun <T> MutableLiveData<Resource<T>>.error(e: String?) {
        value = Resource.error(e)
    }

    protected fun <T> MutableLiveData<Resource<T>>.error(e: Int?) {
        value = Resource.error(e)
    }

    protected fun <T> MutableLiveData<Resource<T>>.loading(boolean: Boolean) {
        value = Resource.loading(boolean)
    }
}
