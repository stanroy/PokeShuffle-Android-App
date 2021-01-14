package com.stanroy.pokesearch.data.entities

import com.stanroy.pokesearch.data.api.responses.pokemon.Move
import com.stanroy.pokesearch.data.api.responses.pokemon.Type

data class Pokemon(
    val name: String,
    val height: Int,
    val weight: Int,
    val order: Int,
    val img: String,
    val types: List<Type>,
    val moves: List<Move>
)
