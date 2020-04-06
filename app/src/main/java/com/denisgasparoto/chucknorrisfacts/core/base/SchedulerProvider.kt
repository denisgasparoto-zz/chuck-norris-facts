package com.denisgasparoto.chucknorrisfacts.core.base

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Denis Gasparoto on 06/04/2020.
 */
interface SchedulerProvider {
    val ui: Scheduler
    val io: Scheduler
    val computation: Scheduler
}

class AppSchedulerProvider :
    SchedulerProvider {

    override val ui: Scheduler = AndroidSchedulers.mainThread()

    override val io: Scheduler = Schedulers.io()

    override val computation = Schedulers.computation()
}
