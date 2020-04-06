package com.denisgasparoto.chucknorrisfacts.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.denisgasparoto.chucknorrisfacts.core.base.SchedulerProvider
import io.mockk.mockk
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.After
import org.junit.Before
import org.junit.Rule

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
abstract class BaseViewModelTest<T> {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    protected lateinit var compositeDisposable: CompositeDisposable
    protected lateinit var testScheduler: TestScheduler
    protected lateinit var schedulerProvider: SchedulerProvider

    abstract val viewModel: T

    @Before
    fun setupTest() {
        RxJavaPlugins.setComputationSchedulerHandler { testScheduler }

        compositeDisposable = mockk(relaxed = true)
        testScheduler = TestScheduler()
        schedulerProvider = TestSchedulerProvider(testScheduler)

        initialize()
    }

    @After
    fun tearDown() {
        RxJavaPlugins.reset()
    }

    abstract fun initialize()
}
