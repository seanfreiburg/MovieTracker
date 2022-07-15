package com.sfreiburg.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.mvrx.compose.mavericksViewModel
import com.sfreiburg.composables.MovieDetails
import com.sfreiburg.framework.navigation.Navigator
import com.sfreiburg.framework.presenters.collectViewModelsAsState
import com.sfreiburg.presenters.MovieDetailsArguments
import com.sfreiburg.presenters.MovieDetailsPresenter

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    navigator: Navigator,
) {
    val presenter: MovieDetailsPresenter = mavericksViewModel(
        argsFactory = { MovieDetailsArguments(movieId = movieId) }
    )
    val viewModel by presenter.collectViewModelsAsState()
    AppThemeFullScreenWrapper {
        MovieDetails(
            movie = viewModel.movie
        )
    }
}
