package com.stanroy.pokesearch.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonParcelable(
    val name: String?,
    val height: Int?,
    val weight: Int?,
    val order: Int?,
    val img: String?,
    val types: List<String>,
    val moves: List<String>
) : Parcelable
