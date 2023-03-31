package com.ada.pokedex_android.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ada.pokedex_android.models.Pokemon
import com.ada.pokedex_android.models.PokemonsList
import com.ada.pokedex_android.network.PokemonService

class PokemonRepository(
    private val pokemonService: PokemonService,
) {

    //PokemonList
    private val _itemsPokemonList = MutableLiveData<PokemonsList>()
    val itemsPokemonList: LiveData<PokemonsList>
        get() = _itemsPokemonList

    //Pokemon by name
    private val _itemsPokemonbyName = MutableLiveData<Pokemon>()
    val itemsPokemonbyName: LiveData<Pokemon>
        get() = _itemsPokemonbyName


    suspend fun getPokemons() {
        val resPokemons = pokemonService.getPokemon()
        if (resPokemons.body() != null) {
            _itemsPokemonList.postValue(resPokemons.body())
        }
    }

    suspend fun getPokemonsByName(name: String) {
        val resPokemonsByName = pokemonService.getPokemonByName(name)
        if (resPokemonsByName.body() != null) {
            _itemsPokemonbyName.postValue(resPokemonsByName.body())
        }
    }
}