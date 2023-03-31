package com.ada.pokedex_android.models

import com.ada.pokedex_android.models.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonsList(
    @SerializedName("results")
    val pokemon: List<Pokemon>
)