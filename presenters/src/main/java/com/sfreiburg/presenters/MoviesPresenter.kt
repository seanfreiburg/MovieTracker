package com.sfreiburg.presenters

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.sfreiburg.framework.navigation.Navigator
import com.sfreiburg.framework.presenters.MavericksPresenter
import com.sfreiburg.models.Movie
import com.sfreiburg.repos.MovieRepo
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

data class MoviesViewModel(val movies: Async<List<Movie>> = Uninitialized, val query: String = "")

data class MoviesState(val movies: Async<List<Movie>> = Uninitialized, val query: String = "") : MavericksState

sealed class MoviesEvent {
    data class SearchTextUpdated(val query: String) : MoviesEvent()
    data class MovieClicked(val navigator: Navigator, val movieId: Int) : MoviesEvent()
}

class MoviesPresenter @AssistedInject constructor(
    @Assisted initialState: MoviesState,
    private val movieRepo: MovieRepo
) : MavericksPresenter<MoviesState, MoviesEvent, MoviesViewModel>(initialState) {

    init {
        viewModelScope.launch {
            setState { copy(movies = Loading()) }
            val moviesResult = movieRepo.fetchTrending()
            if (moviesResult.isSuccess) {
                setState { copy(movies = Success(moviesResult.getOrThrow())) }
            } else {
                setState { copy(movies = Fail(moviesResult.exceptionOrNull()!!)) }
            }
        }
    }

    private var updateJob: Job? = null
    override fun onEvent(event: MoviesEvent) {
        when (event) {
            is MoviesEvent.SearchTextUpdated -> {
                withState { state ->
                    if (event.query == state.query) {
                        return@withState
                    }

                    setState { copy(query = event.query) }

                    // cancel running job because we have a new search to run
                    if (updateJob?.isActive == true) updateJob!!.cancel()

                    if (event.query.isBlank()) {
                        updateJob = viewModelScope.launch {
                            setState { copy(movies = Loading()) }
                            val moviesResult = movieRepo.fetchTrending()
                            if (isActive && moviesResult.isSuccess) {
                                setState { copy(movies = Success(moviesResult.getOrThrow())) }
                            } else if (isActive && moviesResult.isFailure) {
                                setState { copy(movies = Fail(moviesResult.exceptionOrNull()!!)) }
                            }
                        }
                    } else {
                        updateJob = viewModelScope.launch {
                            setState { copy(movies = Loading()) }
                            val searchResult = movieRepo.search(event.query)
                            if (isActive && searchResult.isSuccess) {
                                setState { copy(movies = Success(searchResult.getOrThrow())) }
                            } else if (isActive && searchResult.isFailure) {
                                setState { copy(movies = Fail(searchResult.exceptionOrNull()!!)) }
                            }
                        }
                    }
                }
            }
            is MoviesEvent.MovieClicked -> {
                viewModelScope.launch {
                    event.navigator.goToMovieDetails(event.movieId)
                }
            }
        }
    }

    override fun MoviesState.reduce(): MoviesViewModel {
        return MoviesViewModel(movies = movies, query = query)
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MoviesPresenter, MoviesState> {
        override fun create(state: MoviesState): MoviesPresenter
    }

    companion object :
        MavericksViewModelFactory<MoviesPresenter, MoviesState> by hiltMavericksViewModelFactory()
}
