package com.denisgasparoto.chucknorrisfacts.usecase

import android.content.Context
import com.denisgasparoto.chucknorrisfacts.R
import com.denisgasparoto.chucknorrisfacts.base.BaseUseCaseTest
import com.denisgasparoto.chucknorrisfacts.domain.usecase.GetErrorMessageUseCase
import com.denisgasparoto.chucknorrisfacts.domain.usecase.GetErrorMessageUseCaseImpl
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.IOException


/**
 * @author Denis Gasparoto on 06/04/2020.
 */
class GetErrorMessageUseCaseTest : BaseUseCaseTest<GetErrorMessageUseCase>() {

    private val context = mockk<Context>(relaxed = true)

    override lateinit var useCase: GetErrorMessageUseCase

    override fun setupTest() {
        useCase = GetErrorMessageUseCaseImpl(context)
    }

    @Test
    fun `return connection error message when throwable is an IOException`() {
        val message = "No internet connection"

        every { context.getString(R.string.no_connection_message_error) } returns message

        assertEquals(useCase.getErrorMessage(IOException()), message)

        verify(exactly = 1) { context.getString(R.string.no_connection_message_error) }
        confirmVerified(context)
    }
}
