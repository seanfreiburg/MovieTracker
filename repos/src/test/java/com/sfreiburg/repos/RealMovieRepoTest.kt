package com.sfreiburg.repos

import FakeMoviesService
import com.google.common.truth.Truth.assertThat
import com.sfreiburg.models.Movie
import com.sfreiburg.services.db.Database
import com.sfreiburg.services.db.buildFakeDatabase
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Test
import comsfreiburgservicesdb.Movie as DbMovie

class RealMovieRepoTest {

    private lateinit var db: Database
    private lateinit var network: FakeMoviesService
    private lateinit var repo: MovieRepo
    private val successBody =
        "{\"page\":1,\"results\":[{\"adult\":false,\"backdrop_path\":\"/wcKFYIiVDvRURrzglV9kGu7fpfY.jpg\",\"genre_ids\":[14,28,12],\"id\":453395,\"media_type\":\"movie\",\"title\":\"Doctor Strange in the Multiverse of Madness\",\"original_language\":\"en\",\"original_title\":\"Doctor Strange in the Multiverse of Madness\",\"overview\":\"Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.\",\"popularity\":5940.233,\"poster_path\":\"/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg\",\"release_date\":\"2022-05-04\",\"video\":false,\"vote_average\":7.528,\"vote_count\":4275}]}"
    private val expected = Result.success(
        listOf(
            Movie(
                id = 453395,
                title = "Doctor Strange in the Multiverse of Madness",
                overview = "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
                backdrop_url = "https://image.tmdb.org/t/p/w1280/wcKFYIiVDvRURrzglV9kGu7fpfY.jpg",
                poster_url = "https://image.tmdb.org/t/p/w780/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg",
            )
        )
    )

    @Before
    fun setup() {
        db = buildFakeDatabase()
        network = FakeMoviesService()
        repo = RealMovieRepo(network, db.movieQueries)
    }

    @Test
    fun `fetchTrending fetches success then returns from network`() =
        runBlocking {
            // given
            network.mockWebServer.enqueue(MockResponse().setBody(successBody).setResponseCode(200))

            // when
            val movies = repo.fetchTrending()

            // then
            assertThat(movies).isEqualTo(expected)
            assertThat(
                db.movieQueries.selectById(453395).executeAsOne().title
            ).isEqualTo("Doctor Strange in the Multiverse of Madness")
        }

    @Test
    fun `fetchTrending given server error when fetches then returns failure`() = runBlocking {
        network.mockWebServer.enqueue(MockResponse().setResponseCode(400))

        val movies = repo.fetchTrending()
        assertThat(movies.isFailure).isTrue()
        assertThat(db.movieQueries.selectById(2).executeAsOneOrNull()).isNull()
    }

    @Test
    fun `search fetches success then returns from network`() =
        runBlocking {
            // given
            network.mockWebServer.enqueue(MockResponse().setBody(successBody).setResponseCode(200))

            // when
            val movies = repo.search("query")

            // then
            assertThat(movies).isEqualTo(expected)
            assertThat(
                db.movieQueries.selectById(453395).executeAsOne().title
            ).isEqualTo("Doctor Strange in the Multiverse of Madness")
        }

    @Test
    fun `search given server error when fetches then returns failure`() = runBlocking {
        network.mockWebServer.enqueue(MockResponse().setResponseCode(400))

        val movies = repo.fetchTrending()
        assertThat(movies.isFailure).isTrue()
        assertThat(db.movieQueries.selectById(2).executeAsOneOrNull()).isNull()
    }

    @Test
    fun `getDetails fetches success then returns from network`() =
        runBlocking {
            // given
            db.movieQueries.insertMovie(
                DbMovie(
                    id = 453395,
                    title = "Doctor Strange in the Multiverse of Madness",
                    overview = "Doctor Strange, with the help of mystical allies both old and new, traverses the mind-bending and dangerous alternate realities of the Multiverse to confront a mysterious new adversary.",
                    backdrop_url = "https://image.tmdb.org/t/p/w1280/wcKFYIiVDvRURrzglV9kGu7fpfY.jpg",
                    poster_url = "https://image.tmdb.org/t/p/w780/9Gtg2DzBhmYamXBS1hKAhiwbBKS.jpg",
                )
            )

            // when
            val movies = repo.getDetails(453395)

            // then
            assertThat(movies.getOrNull()).isEqualTo(expected.getOrNull()?.get(0))
        }

    @Test(expected = java.lang.NullPointerException::class)
    fun `getDetails given server error when fetches then returns failure`() = runBlocking {
        val movies = repo.getDetails(453395)
        assertThat(movies.isFailure).isTrue()
    }
}
