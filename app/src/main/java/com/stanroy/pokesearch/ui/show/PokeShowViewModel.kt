package com.stanroy.pokesearch.ui.show

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stanroy.pokesearch.R

class PokeShowViewModel(private val navArgs: PokeShowFragmentArgs, private val app: Application) :
    AndroidViewModel(app) {

    //VIEWMODEL VARIABLES
    private val currentPokemon = navArgs.pokemonParcelable
    val pokeName = currentPokemon.name
    val pokeImg = currentPokemon.img
    private val pokeNumber = currentPokemon.order
    private val pokeHeight = currentPokemon.height!!.toFloat()
    private val pokeWeight = currentPokemon.weight!!.toFloat()
    private val typesList = currentPokemon.types
    private val movesList = currentPokemon.moves
    private val pokeTypes = typesList.joinToString(", ")
    private val pokeMoves = movesList.joinToString(", ")

    private val convertHeight = ((pokeHeight * 100) / 1000).toString()
    private val convertWeight = ((pokeWeight * 100) / 1000).toString()


    val pokeNumberFormat =
        app.applicationContext.resources.getString(R.string.poke_number_temp, pokeNumber)
    val pokeHeightFormat =
        app.applicationContext.resources.getString(R.string.poke_height_temp, convertHeight)
    val pokeWeightFormat =
        app.applicationContext.resources.getString(R.string.poke_weight_temp, convertWeight)
    val pokeTypesFormat =
        app.applicationContext.resources.getString(R.string.poke_types_temp, pokeTypes)
    val pokeMovesFormat =
        app.applicationContext.resources.getString(R.string.poke_moves_temp, pokeMoves)

    //BOOLEAN EVENTS
    private val _setUpViews = MutableLiveData<Boolean>()
    val setUpViews: LiveData<Boolean>
        get() = _setUpViews

    init {
        _setUpViews.value = true
    }

}