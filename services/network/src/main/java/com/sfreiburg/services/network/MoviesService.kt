package com.sfreiburg.services.network

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("trending/movie/week") suspend fun trendingMoviesWeek(): Result<MovieListJson>

    @GET("search/movie") suspend fun search(@Query("query") query: String, @Query("include_adult") includeAdult: Boolean = false): Result<MovieListJson>
}
