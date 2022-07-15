package com.sfreiburg.repos

import com.sfreiburg.models.Movie
import kotlinx.coroutines.flow.MutableStateFlow

class FakeMovieRepo : MovieRepo {
    val moviesStateFlow = MutableStateFlow<Result<List<Movie>>>(Result.success(listOf()))

    override suspend fun fetchTrending(): Result<List<Movie>> {
        return moviesStateFlow.value
    }

    override suspend fun search(query: String): Result<List<Movie>> {
        return Result.success(
            moviesStateFlow.value.getOrThrow().filter {
                it.title.contains(
                    query,
                    ignoreCase = true
                )
            }
        )
    }

    override suspend fun getDetails(movieId: Int): Result<Movie> {
        return Result.success(moviesStateFlow.value.getOrThrow().filter { it.id == movieId }.first())
    }
}
