package com.example.dkt2.repository

import com.example.dkt2.LIMIT
import com.example.dkt2.data.PokemonDetails
import com.example.dkt2.data.PokemonResponse
import com.example.dkt2.network.PokemonApi
import io.reactivex.Observable

class PokemonRepository (val pokemonApi: PokemonApi){

    fun getPokemonList(offset:Int): Observable<PokemonResponse>{
        return  pokemonApi.getPokemonList(offset , LIMIT)
    }

    fun getPokemonDetails(id:Int):Observable<PokemonDetails>{
        return pokemonApi.getPokemonDetails(id)
    }

}