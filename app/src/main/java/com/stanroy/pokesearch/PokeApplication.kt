package com.stanroy.pokesearch

import android.app.Application
import com.stanroy.pokesearch.data.repository.PokeRepository
import com.stanroy.pokesearch.ui.search.PokeSearchViewModel
import com.stanroy.pokesearch.ui.show.PokeShowViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class PokeApplication : Application() {

    private var appModules = module {
        viewModel { PokeSearchViewModel(get(), get()) }
        viewModel { PokeShowViewModel(get(), get()) }
    }

    private var otherModules = module {
        single { PokeRepository() }
    }


    private val allModules = appModules + otherModules

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PokeApplication)
            modules(allModules)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

    }
}