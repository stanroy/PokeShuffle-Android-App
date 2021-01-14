package com.stanroy.pokesearch.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.stanroy.pokesearch.R
import com.stanroy.pokesearch.data.entities.PokemonParcelable
import com.stanroy.pokesearch.databinding.FragmentPokeSearchBinding
import com.stanroy.pokesearch.ui.util.PokeViewAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber


class PokeSearchFragment : Fragment() {

    private val viewModel: PokeSearchViewModel by viewModel()
    private lateinit var mViewAdapter: PokeViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentPokeSearchBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_poke_search, container, false)


        binding.searchViewModel = viewModel

        //VIEWMODEL OBSERVERS
        viewModel.updatePage.observe(viewLifecycleOwner, Observer { shouldUpdate ->

            if (shouldUpdate) {
                //Timber.d(viewModel.pokeData.value!!.name)
                mViewAdapter = PokeViewAdapter(
                    binding.tvPokeName,
                    binding.ivSearchImg,
                    viewModel.pokeData.value
                )

                mViewAdapter.isImageLoaded.observe(viewLifecycleOwner, Observer {
                    if (it) {
                        viewModel.stopLoading()
                    } else {
                        Snackbar.make(
                            requireView(),
                            "Could not load the image",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        viewModel.stopLoading()
                    }
                })

            } else {
                Snackbar.make(requireView(), "No internet connection, trying to reconnect...", Snackbar.LENGTH_SHORT).show()
            }

        })

        viewModel.toggleProgressBar.observe(viewLifecycleOwner, Observer { toggle ->
            if (toggle) {
                binding.pbPokemonSearch.visibility = View.VISIBLE
            } else {
                binding.pbPokemonSearch.visibility = View.GONE
            }
        })

        viewModel.navigateToShowPage.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            val pokeData = viewModel.pokeData.value!!
            val typesList = mutableListOf<String>()
            val movesList = mutableListOf<String>()
            pokeData.types.forEach { type ->
                typesList.add(type.type.name)
            }
            pokeData.moves.forEach { move ->
                movesList.add(move.move.name)
            }
            val pokemonParcel = PokemonParcelable(
                pokeData.name,
                pokeData.height,
                pokeData.weight,
                pokeData.order,
                pokeData.img,
                typesList,
                movesList
            )

            if (shouldNavigate) {
                this.findNavController().navigate(
                    PokeSearchFragmentDirections.actionPokeSearchFragmentToPokeShowFragment(
                        pokemonParcel
                    )
                )
                viewModel.stopNavigatingToShow()
            }
        })

        return binding.root
    }


    //PRIVATE FUNCTIONS


}