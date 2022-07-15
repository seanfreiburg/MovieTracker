package com.sfreiburg.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.mvrx.compose.mavericksViewModel
import com.sfreiburg.composables.Movies
import com.sfreiburg.framework.navigation.Navigator
import com.sfreiburg.framework.presenters.collectViewModelsAsState
import com.sfreiburg.presenters.MoviesEvent
import com.sfreiburg.presenters.MoviesPresenter

@Composable
fun MoviesScreen(
    navigator: Navigator,
) {
    val presenter: MoviesPresenter = mavericksViewModel()
    val viewModel by presenter.collectViewModelsAsState()
    AppThemeFullScreenWrapper {
        Movies(
            movies = viewModel.movies,
            query = viewModel.query,
            onQueryChanged = { newQuery ->
                presenter.onEvent(MoviesEvent.SearchTextUpdated(newQuery))
            },
            onMovieClicked = { movieId ->
                presenter.onEvent(MoviesEvent.MovieClicked(navigator = navigator, movieId = movieId))
            }
        )
    }
}
