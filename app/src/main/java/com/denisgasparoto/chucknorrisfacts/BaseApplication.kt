package com.denisgasparoto.chucknorrisfacts

import android.app.Application
import com.denisgasparoto.chucknorrisfacts.core.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@BaseApplication)
            modules(appModules)
            Timber.d(KOIN_INITALIZED_MESSAGE)
        }
    }

    private companion object {
        private const val KOIN_INITALIZED_MESSAGE = "Koin initialized"
    }
}
