package com.sfreiburg.framework.navigation

interface Navigator {
    suspend fun goToMovies()
    suspend fun goToMovieDetails(movieId: Int)
}
