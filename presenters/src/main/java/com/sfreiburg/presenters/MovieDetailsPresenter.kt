package com.sfreiburg.presenters

import android.os.Parcelable
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.sfreiburg.framework.presenters.MavericksPresenter
import com.sfreiburg.models.Movie
import com.sfreiburg.repos.MovieRepo
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailsArguments(val movieId: Int) : Parcelable

data class MovieDetailsViewModel(val movie: Movie? = null)

data class MovieDetailsState(val movieId: Int = -1, val movie: Movie? = null) : MavericksState {
    constructor(args: MovieDetailsArguments) : this(movieId = args.movieId)
}

sealed class MovieDetailsEvent

class MovieDetailsPresenter @AssistedInject constructor(
    @Assisted initialState: MovieDetailsState,
    private val movieRepo: MovieRepo
) : MavericksPresenter<MovieDetailsState, MovieDetailsEvent, MovieDetailsViewModel>(initialState) {

    init {
        withState { state ->
            viewModelScope.launch {
                val movieResult = movieRepo.getDetails(state.movieId)
                if (movieResult.isSuccess) {
                    setState { copy(movie = movieResult.getOrDefault(null)) }
                }
            }
        }
    }

    override fun onEvent(event: MovieDetailsEvent) {
        when (event) {
            else -> TODO("no events")
        }
    }

    override fun MovieDetailsState.reduce(): MovieDetailsViewModel {
        return MovieDetailsViewModel(movie = movie)
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<MovieDetailsPresenter, MovieDetailsState> {
        override fun create(state: MovieDetailsState): MovieDetailsPresenter
    }

    companion object :
        MavericksViewModelFactory<MovieDetailsPresenter, MovieDetailsState> by hiltMavericksViewModelFactory()
}
