package com.mobileweb3.dvs.android

import android.app.Application
import com.mobileweb3.dvs.app.ValidatorDetailsStore
import com.mobileweb3.dvs.app.ValidatorListStore
import com.mobileweb3.dvs.core.create
import com.mobileweb3.dvs.interactor.MainInteractor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class App : Application() {

    private val appModule = module {
        single { MainInteractor.create(get(), BuildConfig.DEBUG) }
        single { ValidatorListStore(get()) }
        single { ValidatorDetailsStore() }
    }

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            if (BuildConfig.DEBUG) androidLogger(Level.ERROR)

            androidContext(this@App)
            modules(appModule)
        }
    }
}