package com.stanroy.pokesearch.data.api.responses.main


import com.google.gson.annotations.SerializedName

data class MainSearchResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)