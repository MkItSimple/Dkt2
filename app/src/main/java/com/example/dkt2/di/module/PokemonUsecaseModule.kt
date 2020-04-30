package com.example.dkt2.di.module

import com.example.dkt2.repository.PokemonRepository
import com.example.dkt2.di.scope.AppScope
import com.example.dkt2.domain.PokemonUsecase
import dagger.Module
import dagger.Provides

@Module
class PokemonUsecaseModule {
    @AppScope
    @Provides
    fun provideFeedUseCase(repository : PokemonRepository) = PokemonUsecase(repository)
}