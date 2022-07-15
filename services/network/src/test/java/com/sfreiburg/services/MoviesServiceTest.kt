package com.sfreiburg.services

import com.google.common.truth.Truth.assertThat
import com.sfreiburg.services.network.MovieJson
import com.sfreiburg.services.network.MovieListJson
import com.sfreiburg.services.network.MoviesService
import com.sfreiburg.services.network.ResultCallAdapterFactory
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

class MoviesServiceTest {
    private val mockWebServer = MockWebServer()

    private val client =
        OkHttpClient.Builder().connectTimeout(1, TimeUnit.SECONDS).readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS).build()

    private val api = Retrofit.Builder().baseUrl(mockWebServer.url("/")).client(client)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory()).build().create(MoviesService::class.java)

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should list movies correctly given 200 response`() = runBlocking {
        mockWebServer.enqueueResponse("listMovies-200.json", 200)

        val actual: Result<MovieListJson> = api.trendingMoviesWeek()

        val expected = Result.success(
            MovieListJson(
                results = listOf(
                    MovieJson(
                        id = 453395,
                        title = "Doctor Strange in the Multiverse of Madness",
                        overview = "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
                        backdrop_path = "/wcKFYIiVDvRURrzglV9kGu7fpfY.jpg",
                        poster_path = "/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg",
                    )
                )
            )
        )

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `should be failure on given 400 response`() = runBlocking {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        val actual: Result<MovieListJson> = api.trendingMoviesWeek()

        assertThat(actual.isFailure).isTrue()
    }

    @Test
    fun `should search movies correctly given 200 response`() = runBlocking {
        mockWebServer.enqueueResponse("searchMovies-200.json", 200)

        val actual: Result<MovieListJson> = api.search("something")

        val expected = Result.success(
            MovieListJson(
                results = listOf(
                    MovieJson(
                        id = 453395,
                        title = "Doctor Strange in the Multiverse of Madness",
                        overview = "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
                        backdrop_path = "/wcKFYIiVDvRURrzglV9kGu7fpfY.jpg",
                        poster_path = "/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg",
                    )
                )
            )
        )

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `search should be failure on given 400 response`() = runBlocking {
        mockWebServer.enqueue(MockResponse().setResponseCode(400))

        val actual: Result<MovieListJson> = api.search("something")

        assertThat(actual.isFailure).isTrue()
    }
}

internal fun MockWebServer.enqueueResponse(fileName: String, code: Int) {
    val inputStream = javaClass.classLoader!!.getResourceAsStream("api-response/$fileName")!!

    val source = inputStream.source().buffer()
    enqueue(MockResponse().setResponseCode(code).setBody(source.readString(StandardCharsets.UTF_8)))
}
