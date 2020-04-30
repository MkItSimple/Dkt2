package com.example.dkt2.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.dkt2.data.PokemonResponse
import com.example.dkt2.domain.PokemonUsecase
import javax.inject.Inject

class PokeMonListViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var usecase: PokemonUsecase // PokemonRepository

    private val pokemonListMutableLiveData = MutableLiveData<PokemonResponse>()

    fun getPokemonList() {
        if (pokemonListMutableLiveData.value != null) {
            return
        }
        val disposable = usecase.getPokemonList(0)
            .subscribe {
                pokemonListMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonList() = pokemonListMutableLiveData
}