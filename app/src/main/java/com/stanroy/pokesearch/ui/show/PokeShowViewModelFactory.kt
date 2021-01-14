package com.stanroy.pokesearch.ui.show

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stanroy.pokesearch.data.util.Constants
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class PokeShowViewModelFactory(private val navArgs: PokeShowFragmentArgs, private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokeShowViewModel::class.java)){
            return PokeShowViewModel(navArgs,context) as T
        }
        throw IllegalArgumentException(Constants.UNKNOWN_VIEWMODEL)
    }
}