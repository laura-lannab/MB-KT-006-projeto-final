package com.ada.pokedex_android.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ada.mb_kt_006_projeto_final.R
import com.ada.mb_kt_006_projeto_final.databinding.PokemonItemBinding
import com.ada.pokedex_android.models.Pokemon
import com.ada.pokedex_android.models.PokemonsList
import com.bumptech.glide.Glide

class PokemonAdapter(val context: Context, var pokemonList: PokemonsList, val onClickListener: OnClickListener)
    : RecyclerView.Adapter<PokemonAdapter.MyViewHolder>() {

    lateinit var binding: PokemonItemBinding

    class MyViewHolder(var binding: PokemonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.tvName.text = pokemon.name
            binding.ivPokemon.setImageResource(R.drawable.charmander)
            //Glide.with(itemView.context).load(pokemon.url).into(binding.ivPokemon)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = PokemonItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pokemon = pokemonList.pokemon[position]
        holder.bind(pokemon)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(pokemon)
        }
    }

    class OnClickListener(val clickListener: (pokemon: Pokemon) -> Unit) {
        fun onClick(pokemon: Pokemon) =
            clickListener(pokemon)
    }

    override fun getItemCount(): Int = pokemonList.pokemon.size
}