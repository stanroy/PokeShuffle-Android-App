package com.stanroy.pokesearch.ui.search

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stanroy.pokesearch.data.repository.PokeRepository
import com.stanroy.pokesearch.data.util.Constants

@Suppress("UNCHECKED_CAST")
class PokeSearchViewModelFactory(
    private val context: Context,
    private val repository: PokeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokeSearchViewModel::class.java)) {
            return PokeSearchViewModel(context, repository) as T
        }
        throw IllegalArgumentException(Constants.UNKNOWN_VIEWMODEL)

    }
}