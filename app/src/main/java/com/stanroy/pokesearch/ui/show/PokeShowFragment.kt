package com.stanroy.pokesearch.ui.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.stanroy.pokesearch.R
import com.stanroy.pokesearch.databinding.FragmentPokeShowBinding
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class PokeShowFragment : Fragment() {

    private val navArgs by navArgs<PokeShowFragmentArgs>()
    private val viewModel by inject<PokeShowViewModel> { parametersOf(navArgs) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPokeShowBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_poke_show, container, false)

        binding.pokeShowViewModel = viewModel


        //VIEWMODEL OBSERVERS

        viewModel.setUpViews.observe(viewLifecycleOwner, Observer { shouldSetup ->
            if (shouldSetup) {
                Picasso.get().load(viewModel.pokeImg).fit().centerInside()
                    .into(binding.ivShowImg, object : Callback {
                        override fun onSuccess() {

                        }

                        override fun onError(e: Exception?) {
                            Snackbar.make(
                                requireView(),
                                "Could not load the image",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }

                    })
            }
        })


        return binding.root
    }


}