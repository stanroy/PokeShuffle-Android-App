package com.stanroy.pokesearch.data.api.services

import com.stanroy.pokesearch.data.api.responses.main.MainSearchResponse
import com.stanroy.pokesearch.data.api.responses.pokemon.PokemonSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeService {


    @GET("pokemon/{pokeId}")
    fun getPokemon(@Path("pokeId") pokeId: Int): Call<PokemonSearchResponse>

}