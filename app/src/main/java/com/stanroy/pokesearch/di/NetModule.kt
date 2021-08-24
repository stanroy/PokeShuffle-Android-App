package com.stanroy.pokesearch.di

import com.stanroy.pokesearch.data.api.services.PokeService
import com.stanroy.pokesearch.data.util.Constants
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetModule {
    val provider: Module = module {
        single { provideRetrofitInstance() }
        single { provideRetrofitService(get()) }
    }

    private fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideRetrofitService(retrofit: Retrofit): PokeService {
        return retrofit.create(PokeService::class.java)
    }
}