package com.ada.pokedex_android.network

import com.ada.pokedex_android.models.Pokemon
import com.ada.pokedex_android.models.PokemonsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon")
    suspend fun getPokemon() : Response<PokemonsList>

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String
    ) : Response<Pokemon>

}