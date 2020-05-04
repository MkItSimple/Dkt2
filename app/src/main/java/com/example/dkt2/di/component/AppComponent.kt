package com.example.dkt2.di.component

import com.example.dkt2.di.module.AppModule
import com.example.dkt2.di.scope.AppScope
import com.example.dkt2.di.subcomponent.PokemonDetailsComponent
import com.example.dkt2.di.subcomponent.PokemonListComponent
import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun newPokemonLisComponent(): PokemonListComponent
    fun newPokemonDetailsComponent(): PokemonDetailsComponent
}