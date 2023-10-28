package com.seanaujong.pokedex.util

sealed class Content<out T> {
    data class Success<T>(val data: T) : Content<T>()
    data class Error(val message: String) : Content<Nothing>()
    object Loading : Content<Nothing>()
}