package com.sfreiburg.models

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val backdrop_url: String,
    val poster_url: String,
)
