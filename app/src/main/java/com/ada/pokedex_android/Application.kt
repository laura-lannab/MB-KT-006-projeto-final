package com.ada.pokedex_android

import android.app.Application
import com.ada.pokedex_android.network.PokemonService
import com.ada.pokedex_android.network.RetrofitHelper
import com.ada.pokedex_android.repository.PokemonRepository

class Application : Application() {

    lateinit var pokemonRepository: PokemonRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val swService = RetrofitHelper(applicationContext).getInstance().create(PokemonService::class.java)
        pokemonRepository = PokemonRepository(swService)
    }
}