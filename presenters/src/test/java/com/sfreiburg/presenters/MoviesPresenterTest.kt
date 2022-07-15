package com.sfreiburg.presenters

import app.cash.turbine.test
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.test.MvRxTestRule
import com.google.common.truth.Truth.assertThat
import com.sfreiburg.framework.navigation.FakeNavigator
import com.sfreiburg.models.Movie
import com.sfreiburg.repos.FakeMovieRepo
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MoviesPresenterTest {
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

    private val navigator = FakeNavigator()

    @Before
    fun setup() {
        fakeMovieRepo = FakeMovieRepo()
    }

    @Test
    fun fetchesMoviesOnInit() = runBlocking {
        fakeMovieRepo.moviesStateFlow.value = Result.success(movies)
        val presenter = MoviesPresenter(MoviesState(), fakeMovieRepo)
        presenter.awaitState()
        presenter.viewModelFlow.test {
            assertThat(awaitItem()).isEqualTo(MoviesViewModel(movies = Success(movies)))
        }
    }

    @Test
    fun navigatesOnMovieClicked() = runBlocking {
        fakeMovieRepo.moviesStateFlow.value = Result.success(movies)
        val presenter = MoviesPresenter(MoviesState(), fakeMovieRepo)

        presenter.onEvent(MoviesEvent.MovieClicked(navigator, 1))
        assertThat(navigator.awaitScreen()).isEqualTo("movieDetails/1")
    }

    @Test
    fun fetchesTrendingOnQueryEmpty() = runBlocking {
        fakeMovieRepo.moviesStateFlow.value = Result.success(movies)
        val presenter = MoviesPresenter(MoviesState(), fakeMovieRepo)
        presenter.awaitState()
        presenter.viewModelFlow.test {
            assertThat(awaitItem()).isEqualTo(MoviesViewModel(movies = Success(movies)))
        }

        presenter.onEvent(MoviesEvent.SearchTextUpdated("a"))
        presenter.onEvent(MoviesEvent.SearchTextUpdated(""))
        presenter.awaitState()
        presenter.viewModelFlow.test {
            assertThat(awaitItem()).isEqualTo(MoviesViewModel(movies = Success(movies)))
        }
    }

    @Test
    fun fetchesQueryNotEmpty() = runBlocking {
        fakeMovieRepo.moviesStateFlow.value = Result.success(movies)
        val presenter = MoviesPresenter(MoviesState(), fakeMovieRepo)
        presenter.awaitState()
        presenter.viewModelFlow.test {
            assertThat(awaitItem()).isEqualTo(MoviesViewModel(movies = Success(movies)))
        }

        presenter.onEvent(MoviesEvent.SearchTextUpdated("pirates"))
        presenter.awaitState()
        presenter.viewModelFlow.test {
            assertThat(awaitItem()).isEqualTo(MoviesViewModel(query = "pirates", movies = Success(listOf(movies[1]))))
        }
    }
}
