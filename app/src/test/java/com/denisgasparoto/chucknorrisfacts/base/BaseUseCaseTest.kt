package com.denisgasparoto.chucknorrisfacts.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
abstract class BaseUseCaseTest<T> {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    abstract val useCase: T

    @Before
    abstract fun setupTest()
}
