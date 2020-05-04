package com.example.dkt2.ui

import com.example.dkt2.R
import com.example.dkt2.data.Pokemon
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.item_list.view.*

class PokemonItems(val pokemon: Pokemon) : Item<ViewHolder>() {
    override fun getLayout() = R.layout.item_list

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.pokemonName.text = pokemon.name
    }
}