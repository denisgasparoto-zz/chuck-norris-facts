package com.denisgasparoto.chucknorrisfacts.domain.usecase

import android.content.Context
import com.denisgasparoto.chucknorrisfacts.R
import retrofit2.HttpException
import java.io.IOException

/**
 * @author Denis Gasparoto on 04/04/2020.
 */
interface GetErrorMessageUseCase {
    fun getErrorMessage(error: Throwable): String
}

class GetErrorMessageUseCaseImpl(
    private val androidContext: Context
) : GetErrorMessageUseCase {

    override fun getErrorMessage(error: Throwable): String {
        return when (error) {
            is HttpException -> when (error.code()) {
                in 400..499 -> androidContext.getString(R.string.bad_request_message_error)
                in 500..599 -> androidContext.getString(R.string.server_error_message_error)
                else -> androidContext.getString(R.string.unknown_error_message_error)
            }
            is IOException -> androidContext.getString(R.string.no_connection_message_error)
            else -> androidContext.getString(R.string.unknown_error_message_error)
        }
    }
}
