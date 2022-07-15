package com.sfreiburg.presenters

import app.cash.turbine.test
import com.airbnb.mvrx.test.MvRxTestRule
import com.google.common.truth.Truth.assertThat
import com.sfreiburg.models.Movie
import com.sfreiburg.repos.FakeMovieRepo
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieDetailsPresenterTest {
    @get:Rule
    val mvrxRule = MvRxTestRule()

    private lateinit var fakeMovieRepo: FakeMovieRepo
    private val movies = listOf(
        Movie(
            id = 1,
            title = "Spiderman",
            overview = "Spiderman saves people",
            backdrop_url = "backdrop_path",
            poster_url = "poster_path",
        ),
        Movie(
            id = 2,
            title = "Pirates",
            overview = "Pirates save people",
            backdrop_url = "backdrop_path",
            poster_url = "poster_path",
        )
    )

    @Before
    fun setup() {
        fakeMovieRepo = FakeMovieRepo()
    }

    @Test
    fun fetchesMoviesOnInit() = runBlocking {
        fakeMovieRepo.moviesStateFlow.value = Result.success(movies)
        val presenter = MovieDetailsPresenter(MovieDetailsState(movieId = 1), fakeMovieRepo)
        presenter.awaitState()
        presenter.viewModelFlow.test {
            assertThat(awaitItem()).isEqualTo(MovieDetailsViewModel(movie = movies[0]))
        }
    }
}
