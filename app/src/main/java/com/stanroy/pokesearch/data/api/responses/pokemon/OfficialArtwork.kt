package com.stanroy.pokesearch.data.api.responses.pokemon


import com.google.gson.annotations.SerializedName

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String
)