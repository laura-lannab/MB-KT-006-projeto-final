package com.ada.pokedex_android.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ada.mb_kt_006_projeto_final.R
import com.ada.mb_kt_006_projeto_final.databinding.ActivityMainBinding
import com.ada.pokedex_android.Application
import com.ada.pokedex_android.view.adapters.PokemonAdapter
import com.ada.pokedex_android.viewmodel.PokemonViewModel
import com.ada.pokedex_android.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

/*    private val pokemons = listOf<Pokemon>(
        Pokemon(1, "Pikachu", listOf(PokemonType("Elétrico"), PokemonType("Estressado"))),
        Pokemon(2, "Charmander", listOf(PokemonType("Fogo"), PokemonType("Esquentado"))),
        Pokemon(3, "Bulbasaur", listOf(PokemonType("Planta"), PokemonType("Folgado"))),
    )*/

    private lateinit var pokemonViewModel: PokemonViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.rvPokemons.setHasFixedSize(true)
        binding.rvPokemons.layoutManager = LinearLayoutManager(this)

        val pokemonRepository = (application as Application).pokemonRepository
        pokemonViewModel =
            ViewModelProvider(this, ViewModelFactory(pokemonRepository))[PokemonViewModel::class.java]

        pokemonViewModel.pokemons.observe(this) { pokemonList ->
            pokemonList.let { pokemonList ->
                adapter = PokemonAdapter(this, pokemonList,
                    PokemonAdapter.OnClickListener { pokemon ->
                        val mIntent = Intent(this, DetailActivity::class.java)
                        val mBundle = Bundle()
                        mBundle.putString("name", pokemon.name)
                        mIntent.putExtras(mBundle)
                        startActivity(mIntent)
                    }
                )
                binding.rvPokemons.adapter = adapter
                adapter.notifyDataSetChanged()
            }
        }

        pokemonViewModel.pokemonByName.observe(this) { pokemon ->
            pokemon.let { pokemon ->
                Log.d("Buscando o NAME Pikachu", "onCreate: ${pokemon}")
            }
        }
    }
}