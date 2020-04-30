package com.example.dkt2.ui

import androidx.lifecycle.MutableLiveData
import com.example.dkt2.data.PokemonResponse
import com.example.dkt2.domain.PokemonUsecase
import com.example.dkt2.viewmodel.BaseViewModel
import javax.inject.Inject

class PokemonListViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var usecase: PokemonUsecase

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
