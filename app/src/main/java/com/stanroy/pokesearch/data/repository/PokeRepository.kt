package com.stanroy.pokesearch.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stanroy.pokesearch.data.api.services.PokeService
import com.stanroy.pokesearch.data.entities.Pokemon
import com.stanroy.pokesearch.data.util.Constants
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class PokeRepository {

    private val pokeService: PokeService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokeService::class.java)

    private var pokeData: MutableLiveData<Pokemon> = MutableLiveData<Pokemon>()


    suspend fun searchPokemon(pokeId: Int) {
        val response = pokeService.getPokemon(pokeId).awaitResponse()


        if (response.isSuccessful) {
            val resBody = response.body()!!
            val pokemon = Pokemon(resBody.name,resBody.height,resBody.weight,resBody.id,resBody.sprites.frontDefault, resBody.types, resBody.moves)
            pokeData.postValue(pokemon)
        }

    }

    fun getPokemon(): LiveData<Pokemon> {
        return pokeData
    }


}