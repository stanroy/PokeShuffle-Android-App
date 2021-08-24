package com.stanroy.pokesearch.di

import com.stanroy.pokesearch.ui.search.PokeSearchViewModel
import com.stanroy.pokesearch.ui.show.PokeShowViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ViewModelModule {
    val provider: Module = module {
        viewModel { params -> PokeShowViewModel(navArgs = params.get(), androidApplication()) }
        viewModel { PokeSearchViewModel(get()) }
    }
}