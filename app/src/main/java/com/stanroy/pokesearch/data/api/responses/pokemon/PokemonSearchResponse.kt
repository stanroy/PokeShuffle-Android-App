package com.stanroy.pokesearch.data.api.responses.pokemon


import com.google.gson.annotations.SerializedName

data class PokemonSearchResponse(
    @SerializedName("abilities")
    val abilities: List<Ability>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    @SerializedName("forms")
    val forms: List<Form>,
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice>,
    @SerializedName("height")
    val height: Int,
    @SerializedName("held_items")
    val heldItems: List<Any>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    @SerializedName("moves")
    val moves: List<Move>,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("species")
    val species: Species,
    @SerializedName("sprites")
    val sprites: Sprites,
    @SerializedName("stats")
    val stats: List<Stat>,
    @SerializedName("types")
    val types: List<Type>,
    @SerializedName("weight")
    val weight: Int
)