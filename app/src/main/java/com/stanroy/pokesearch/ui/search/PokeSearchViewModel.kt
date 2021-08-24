package com.stanroy.pokesearch.ui.search

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stanroy.pokesearch.data.entities.Pokemon
import com.stanroy.pokesearch.data.repository.PokeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.random.Random

class PokeSearchViewModel(private val repository: PokeRepository) :
    ViewModel() {

    //ASYNC VARIABLES
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    //VIEWMODEL VARIABLES
    lateinit var pokeData: LiveData<Pokemon>
    private var randomPokeId: Int = Random.nextInt(1, 898)


    //BOOLEAN EVENTS
    private val _updatePage = MutableLiveData<Boolean>()
    val updatePage: LiveData<Boolean>
        get() = _updatePage


    private val _toggleProgressBar = MutableLiveData<Boolean>()
    val toggleProgressBar: LiveData<Boolean>
        get() = _toggleProgressBar

    private val _navigateToShowPage = MutableLiveData<Boolean>()
    val navigateToShowPage: LiveData<Boolean>
        get() = _navigateToShowPage

    init {
        _toggleProgressBar.value = true

        shufflePokemon(randomPokeId)
    }


    fun nextPokemon() {
        randomPokeId = Random.nextInt(1, 898)
        _toggleProgressBar.value = true
        shufflePokemon(randomPokeId)
    }

    private fun shufflePokemon(id: Int) {
        ioScope.launch {
            try {
                repository.searchPokemon(id)
                pokeData = repository.getPokemon()
                _updatePage.postValue(true)

            } catch (e: Exception) {
                Timber.d(e.localizedMessage)
                if (e.localizedMessage!!.contains("Unable to resolve host")) {
                    _updatePage.postValue(false)
                    Handler(Looper.getMainLooper()).postDelayed({
                        shufflePokemon(id)
                    }, 10000)
                } else {
                    _updatePage.postValue(false)
                }
            }
        }

    }


    fun stopLoading() {
        _toggleProgressBar.postValue(false)
    }

    fun startLoading() {
        _toggleProgressBar.value = true
    }

    fun navigateToShow() {
        _navigateToShowPage.value = true
    }

    fun stopNavigatingToShow() {
        _navigateToShowPage.value = false
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}