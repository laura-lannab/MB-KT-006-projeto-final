package com.ada.pokedex_android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ada.pokedex_android.models.Pokemon
import com.ada.pokedex_android.models.PokemonsList
import com.ada.pokedex_android.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokemonRepository
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemons()
            repository.getPokemonsByName("Pikachu")
        }
    }

    val pokemons: LiveData<PokemonsList>
        get() = repository.itemsPokemonList


    val pokemonByName: LiveData<Pokemon>
        get() = repository.itemsPokemonbyName
}