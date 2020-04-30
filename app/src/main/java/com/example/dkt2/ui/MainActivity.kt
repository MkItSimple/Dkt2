package com.example.dkt2.ui

import com.example.dkt2.R


class MainActivity : BaseActivity() {

    override fun getLayoutById() = R.layout.activity_main
    private val pokemonListFragment = PokemonListFragment()

    override fun initUI() {
        supportFragmentManager.beginTransaction().add(R.id.container, pokemonListFragment).commit()
    }
}
