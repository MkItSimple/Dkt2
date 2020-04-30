package com.example.dkt2.di.module

import com.example.dkt2.repository.PokemonRepository
import com.example.dkt2.di.scope.AppScope
import com.example.dkt2.network.PokemonApi
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @AppScope
    @Provides
    fun provideFeedRepository(api: PokemonApi) = PokemonRepository(api)
}