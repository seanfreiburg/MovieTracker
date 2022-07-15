package com.sfreiburg.repos

import com.sfreiburg.models.Movie

interface MovieRepo {
    suspend fun fetchTrending(): Result<List<Movie>>
    suspend fun search(query: String): Result<List<Movie>>
    suspend fun getDetails(movieId: Int): Result<Movie>
}
