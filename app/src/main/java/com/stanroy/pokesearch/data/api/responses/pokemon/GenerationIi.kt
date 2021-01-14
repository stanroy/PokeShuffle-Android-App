package com.stanroy.pokesearch.data.api.responses.pokemon


import com.google.gson.annotations.SerializedName
import com.stanroy.pokesearch.data.api.responses.pokemonfrontDefault.Crystal

data class GenerationIi(
    @SerializedName("crystal")
    val crystal: Crystal,
    @SerializedName("gold")
    val gold: Gold,
    @SerializedName("silver")
    val silver: Silver
)