package com.example.dkt2.network

import com.example.dkt2.data.PokemonDetails
import com.example.dkt2.data.PokemonResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("api/v2/pokemon")
    //@GET("api/pokemon/1000")
    fun getPokemonList( @Query("offset") offset: Int, @Query("limit") limit: Int):
            Observable<PokemonResponse>

    @GET("api/v2/pokemon/{id}/")
    //@GET("api/pokemon/{id}/")
    fun getPokemonDetails(@Path("id") id:Int) : Observable<PokemonDetails>
}