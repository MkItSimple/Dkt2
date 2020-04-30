package com.example.dkt2.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.dkt2.data.PokemonDetails
import com.example.dkt2.domain.PokemonUsecase
import javax.inject.Inject

class PokemonDetailsViewModel @Inject constructor(private val usecase: PokemonUsecase)  : BaseViewModel() {

    private val pokemonDetailsMutableLiveData  = MutableLiveData<PokemonDetails>()

    fun getPokemonDetails(id:Int) {
        val disposable = usecase.getPokemonDetails(id)
            .subscribe {
                pokemonDetailsMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonDetails() = pokemonDetailsMutableLiveData
}