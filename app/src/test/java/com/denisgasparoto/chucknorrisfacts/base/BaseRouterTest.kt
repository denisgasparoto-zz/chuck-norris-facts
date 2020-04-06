package com.denisgasparoto.chucknorrisfacts.base

import org.junit.Before

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
abstract class BaseRouterTest<T> {

    abstract val router: T

    @Before
    abstract fun setupTest()
}
