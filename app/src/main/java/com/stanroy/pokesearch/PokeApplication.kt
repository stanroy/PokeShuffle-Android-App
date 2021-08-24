package com.stanroy.pokesearch

import android.app.Application
import com.stanroy.pokesearch.di.NetModule
import com.stanroy.pokesearch.di.RepositoryModule
import com.stanroy.pokesearch.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class PokeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokeApplication)
            modules(
                listOf(
                    NetModule.provider,
                    RepositoryModule.provider,
                    ViewModelModule.provider
                )
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}