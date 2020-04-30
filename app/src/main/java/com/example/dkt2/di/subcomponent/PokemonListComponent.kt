package com.example.dkt2.di.subcomponent

import com.example.dkt2.di.module.PokemonListViewModelModule
import com.example.dkt2.di.module.ViewModelFactoryModule
import com.example.dkt2.di.scope.FragmentScope
import com.example.dkt2.ui.PokemonListFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonListViewModelModule::class
    ]
)
interface PokemonListComponent {
    fun inject(pokemonListFragment: PokemonListFragment)
}