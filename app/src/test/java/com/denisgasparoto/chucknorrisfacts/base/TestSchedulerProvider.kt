package com.denisgasparoto.chucknorrisfacts.base

import com.denisgasparoto.chucknorrisfacts.core.base.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
class TestSchedulerProvider(
    testScheduler: TestScheduler
) : SchedulerProvider {

    override val ui: Scheduler = testScheduler

    override val io: Scheduler = testScheduler

    override val computation: Scheduler = testScheduler
}
