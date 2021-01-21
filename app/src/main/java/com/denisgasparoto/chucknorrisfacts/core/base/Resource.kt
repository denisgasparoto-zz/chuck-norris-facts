package com.denisgasparoto.chucknorrisfacts.core.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe

/**
 * @author Denis Gasparoto on 20/01/2021.
 */
sealed class Resource<T> {

    data class Success<T>(val data: T?) : Resource<T>()
    data class Error<T>(val message: String?) : Resource<T>()
    data class LocalError<T>(val message: Int?) : Resource<T>()
    data class Loading<T>(val isLoading: Boolean) : Resource<T>()

    companion object {
        fun <T> success(data: T?): Resource<T> = Success(data)
        fun <T> error(message: String?): Resource<T> = Error(message)
        fun <T> error(message: Int?): Resource<T> = LocalError(message)
        fun <T> loading(isLoading: Boolean): Resource<T> = Loading(isLoading)
    }
}


fun <T> LiveData<Resource<T>>.observeResource(
    owner: LifecycleOwner,
    onSuccess: (T) -> Unit,
    onError: (String) -> Unit,
    onLocalError: (Int) -> Unit,
    onLoading: (Boolean) -> Unit
) {

    observe(owner) { resource ->
        when (resource) {
            is Resource.Success -> resource.data?.let { onSuccess.invoke(it) }
            is Resource.Error -> resource.message?.let { onError.invoke(it) }
            is Resource.LocalError -> resource.message?.let { onLocalError.invoke(it) }
            is Resource.Loading -> onLoading.invoke(resource.isLoading)
        }
    }
}
