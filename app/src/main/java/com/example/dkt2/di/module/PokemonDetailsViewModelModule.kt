package com.example.dkt2.di.module

import androidx.lifecycle.ViewModel
import com.example.dkt2.viewmodel.PokemonDetailsViewModel
import com.example.dkt2.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PokemonDetailsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailsViewModel::class)
    internal abstract fun bindPokemonDetailsViewModel(viewModel: PokemonDetailsViewModel): ViewModel
}