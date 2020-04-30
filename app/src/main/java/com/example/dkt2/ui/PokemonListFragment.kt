package com.example.dkt2.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dkt2.BaseApp
import com.example.dkt2.POKEMON_DETAILS_KEY
import com.example.dkt2.R
import com.example.dkt2.data.PokemonResponse
import com.example.dkt2.viewmodel.PokeMonListViewModel
import com.example.dkt2.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.pokemon_list_fragment.*
import javax.inject.Inject

class PokemonListFragment : Fragment(), OnClickListener {
    private val pokemonDetailsFragment = PokemonDetailsFragment()

    private lateinit var pokeMonListViewModel: PokeMonListViewModel
    val pokadapter = PokemonListAdapter()

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
        initUI(view)
    }

    fun setupView(view: View) {
        val linearLayoutManager = LinearLayoutManager(context)
        pokadapter.setClickListener(this)
        pokemonList.apply {
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = pokadapter
        }
    }

    fun getPokemonListData() {
        pokeMonListViewModel.getPokemonList()
        observePokemonList()
    }

    fun setData(response: PokemonResponse?) {
        response?.results?.let { pokadapter.addPokmons(it) }
    }

    override fun onClick(position: Int, view: View) {
        getPokemonDetails(position+2)
    }

    fun observePokemonList() {
        pokeMonListViewModel.getLivePokemonList().observe(this, Observer {
            setData(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pokemon_list_fragment, container, false)
    }

    fun initUI(view: View) {
        setupView(view)
        getPokemonListData()
    }

    fun getPokemonDetails(id: Int) {
        val bundle = Bundle()
        bundle.putInt(POKEMON_DETAILS_KEY,id)
        pokemonDetailsFragment.arguments = bundle

        Log.d("PLF", "getPokemonDetails $id");

        (activity as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.container, pokemonDetailsFragment)
            .addToBackStack(null)
            .commit()
    }

}
