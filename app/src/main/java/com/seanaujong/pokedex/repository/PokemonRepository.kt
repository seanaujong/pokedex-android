package com.seanaujong.pokedex.repository

import com.seanaujong.pokedex.data.remote.PokeApi
import com.seanaujong.pokedex.data.remote.responses.Pokemon
import com.seanaujong.pokedex.data.remote.responses.PokemonList
import com.seanaujong.pokedex.util.Content
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Content<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch(e: Exception) {
            return Content.Error("An unknown error occurred")
        }
        return Content.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Content<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch(e: Exception) {
            return Content.Error("An unknown error occurred")
        }
        return Content.Success(response)
    }
}