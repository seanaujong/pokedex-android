package com.seanaujong.pokedex.ui.screen.pokemonlist

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.seanaujong.pokedex.data.models.PokedexListEntry
import com.seanaujong.pokedex.repository.PokemonRepository
import com.seanaujong.pokedex.util.Constants.PAGE_SIZE
import com.seanaujong.pokedex.util.Content
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : ViewModel() {

    private var curPage = 0

    var pokemonList = mutableStateOf(listOf<PokedexListEntry>())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    private var cachedPokemonList = listOf<PokedexListEntry>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)

    /**
     * TODO: this is a client side search because the api doesn't offer search capabilities
     * That means the search function can't find any pokemon we haven't loaded.
     * We should find a way to find pokemon we haven't loaded yet.
     * Proposal: fetch all pokemon and store them with Room
     */
    fun searchPokemonList(query: String) {
        val listToSearch = if (isSearchStarting) {
            pokemonList.value
        } else {
            cachedPokemonList
        }
        viewModelScope.launch(dispatcher) {
            if (query.isEmpty()) {
                pokemonList.value = cachedPokemonList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.pokemonName.contains(query.trim(), ignoreCase = true) ||
                        it.number.toString() == query.trim()
            }
            if (isSearchStarting) {
                cachedPokemonList = pokemonList.value
                isSearchStarting = false
            }
            pokemonList.value = results
            isSearching.value = true
        }
    }

    init {
        loadPokemonPaginated()
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch {
            when (val result = repository.getPokemonList(PAGE_SIZE, curPage * PAGE_SIZE)) {
                is Content.Success -> {
                    endReached.value = curPage * PAGE_SIZE >= result.data.count
                    val pokedexEntries = result.data.results.map { entry ->
                        /**
                         * For a URL like https://pokeapi.co/api/v2/pokemon/123/
                         * 1. Sanitize to https://pokeapi.co/api/v2/pokemon/123
                         * 2. Take the "123"
                         */
                        val number = entry.url
                            .dropLastWhile { !it.isDigit() }
                            .takeLastWhile { it.isDigit() }
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
                        PokedexListEntry(entry.name.capitalize(Locale.ROOT), url, number.toInt())
                    }
                    curPage++

                    loadError.value = ""
                    isLoading.value = false
                    pokemonList.value += pokedexEntries
                }

                is Content.Loading -> {
                    // TODO: use this instead of isLoading
                }

                is Content.Error -> {
                    loadError.value = result.message
                    isLoading.value = false
                }
            }
        }
    }

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }
    }
}