package com.stanroy.pokesearch.ui.util

import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.stanroy.pokesearch.data.entities.Pokemon

class PokeViewAdapter(
    title: TextView,
    img: ImageView,
    pokemon: Pokemon?
) {

    var isImageLoaded = MutableLiveData<Boolean>()

    init {
        if (pokemon != null) {
            title.text = pokemon.name
            Picasso.get().load(pokemon.img).fit().centerInside()
                .into(img, object : Callback {
                    override fun onSuccess() {
                        isImageLoaded.postValue(true)
                    }

                    override fun onError(e: Exception?) {
                        isImageLoaded.postValue(false)
                    }

                })
        } else {
            title.text = " "
        }


    }


}