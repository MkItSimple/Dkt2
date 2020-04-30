package com.example.dkt2.di.subcomponent

import com.example.dkt2.di.module.PokemonDetailsViewModelModule
import com.example.dkt2.di.module.ViewModelFactoryModule
import com.example.dkt2.di.scope.FragmentScope
import com.example.dkt2.ui.PokemonDetailsFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonDetailsViewModelModule::class
    ]
)
interface PokemonDetailsComponent {
    fun inject(pokemonDetailsFragment: PokemonDetailsFragment)
}