package com.example.dkt2

import android.app.Application
import com.example.dkt2.di.component.AppComponent
import com.example.dkt2.di.component.DaggerAppComponent
import com.example.dkt2.di.module.NetworkModule
import com.example.dkt2.di.module.PokemonUsecaseModule
import com.example.dkt2.di.module.RepositoryModule

class BaseApp : Application(){
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger()  = DaggerAppComponent.builder()
        .networkModule(NetworkModule())
        .repositoryModule(RepositoryModule())
        .pokemonUsecaseModule(PokemonUsecaseModule())
        .build()
}