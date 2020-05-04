package com.example.dkt2.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dkt2.BaseApp
import com.example.dkt2.POKEMON_DETAILS_KEY
import com.example.dkt2.R
import com.example.dkt2.data.PokemonResponse
import com.example.dkt2.viewmodel.PokeMonListViewModel
import com.example.dkt2.viewmodel.ViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.pokemon_list_fragment.*
import javax.inject.Inject

class PokemonListFragment : Fragment(R.layout.pokemon_list_fragment) {

    companion object {
        val TAG = "PokemonList"
        val USER_KEY = "USER_KEY"
    }

    private val pokemonDetailsFragment = PokemonDetailsFragment()

    private lateinit var pokeMonListViewModel: PokeMonListViewModel
    private val adapter = GroupAdapter<ViewHolder>()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ( activity?.applicationContext as BaseApp).appComponent
            .newPokemonLisComponent().inject(this)
        pokeMonListViewModel = ViewModelProviders.of(this,viewModelFactory)[PokeMonListViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initUI()
        setupDummyData()
    }

    private fun setupDummyData() {
        pokeMonListViewModel.getPokemonList()

        pokeMonListViewModel.getLivePokemonList().observe(this, Observer {
            setData(it)
        })
    }

    fun setData(response: PokemonResponse?) {
        val pokemons = response?.results

        for (pokemon in pokemons!!){
            adapter.add(PokemonItems(pokemon))
        }

        adapter.setOnItemClickListener { item, view ->
            val pokemonItem = item as PokemonItems
            val pid = pokemonItem.pokemon.url.substring(34,35).toInt()

            val bundle = Bundle()
            bundle.putInt(POKEMON_DETAILS_KEY, pid)
            pokemonDetailsFragment.arguments = bundle

            (activity as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.container, pokemonDetailsFragment)
                .addToBackStack(null)
                .commit()
        }

        pokemonList.adapter = adapter
    }
}
