package com.stanroy.pokesearch.di

import com.stanroy.pokesearch.data.repository.PokeRepository
import org.koin.core.module.Module
import org.koin.dsl.module


object RepositoryModule {
    val provider: Module = module {
        single { PokeRepository(get()) }
    }
}