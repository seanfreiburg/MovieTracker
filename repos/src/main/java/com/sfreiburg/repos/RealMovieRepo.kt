package com.sfreiburg.repos

import com.sfreiburg.models.Movie
import com.sfreiburg.services.network.MovieJson
import com.sfreiburg.services.network.MoviesService
import com.sfreiburg.services.network.NetworkModule.Companion.IMAGES_BASE_URL
import comsfreiburgservicesdb.MovieQueries
import java.io.IOException
import javax.inject.Inject

class RealMovieRepo @Inject constructor(
    private val moviesService: MoviesService,
    private val movieQueries: MovieQueries
) : MovieRepo {
    override suspend fun fetchTrending(): Result<List<Movie>> {
        val freshMoviesResult = fetchMoviesFromNetwork()
        if (freshMoviesResult.isFailure) {
            return freshMoviesResult
        }
        val networkMovies = checkNotNull(freshMoviesResult.getOrNull())
        movieQueries.transaction {
            networkMovies.forEach {
                movieQueries.insertMovie(it.toDbMovie())
            }
        }
        return Result.success(networkMovies)
    }

    override suspend fun search(query: String): Result<List<Movie>> {
        val moviesListResponse = moviesService.search(query)
        return if (moviesListResponse.isSuccess) {
            val body = checkNotNull(moviesListResponse.getOrThrow())
            val moviesList = body.results.filterNullPosters().map { it.toMovie() }
            movieQueries.transaction {
                moviesList.forEach {
                    movieQueries.insertMovie(it.toDbMovie())
                }
            }
            Result.success(moviesList)
        } else {
            Result.failure(IOException(moviesListResponse.exceptionOrNull().toString()))
        }
    }

    override suspend fun getDetails(movieId: Int): Result<Movie> {
        val dbMovie = movieQueries.selectById(id = movieId).executeAsOne()
        return Result.success(dbMovie.toMovie())
    }

    private suspend fun fetchMoviesFromNetwork(): Result<List<Movie>> {
        val moviesListResponse = moviesService.trendingMoviesWeek()
        return if (moviesListResponse.isSuccess) {
            val body = checkNotNull(moviesListResponse.getOrThrow())
            val moviesList = body.results.filterNullPosters().map { it.toMovie() }
            Result.success(moviesList)
        } else {
            Result.failure(IOException(moviesListResponse.exceptionOrNull().toString()))
        }
    }

    private fun List<MovieJson>.filterNullPosters(): List<MovieJson> {
        return this.filter { it.backdrop_path != null && it.poster_path != null }
    }

    companion object {
        private const val BACKDROP_IMAGE_SIZE = "w1280"
        private const val POSTER_IMAGE_SIZE = "w780"

        fun MovieJson.toMovie(): Movie = Movie(
            id = this.id,
            title = this.title,
            overview = this.overview,
            backdrop_url = IMAGES_BASE_URL + BACKDROP_IMAGE_SIZE + this.backdrop_path!!,
            poster_url = IMAGES_BASE_URL + POSTER_IMAGE_SIZE + this.poster_path!!,
        )

        fun Movie.toDbMovie(): comsfreiburgservicesdb.Movie = comsfreiburgservicesdb.Movie(
            id = this.id,
            title = this.title,
            overview = this.overview,
            backdrop_url = this.backdrop_url,
            poster_url = this.poster_url,
        )

        fun comsfreiburgservicesdb.Movie.toMovie(): Movie = Movie(
            id = this.id,
            title = this.title,
            overview = this.overview,
            backdrop_url = this.backdrop_url,
            poster_url = this.poster_url,
        )
    }
}
