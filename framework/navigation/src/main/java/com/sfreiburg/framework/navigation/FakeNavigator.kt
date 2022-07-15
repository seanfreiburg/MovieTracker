package com.sfreiburg.framework.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.withTimeout

class FakeNavigator : Navigator {

    private val screens = Channel<String>(capacity = Channel.UNLIMITED)

    private suspend fun navigate(destination: String) {
        screens.trySend(destination)
    }

    private suspend fun popBackStack(route: String, inclusive: Boolean) {
        TODO("Not yet implemented")
    }

    suspend fun awaitScreen(): String {
        return withTimeout(1000L) {
            screens.receive()
        }
    }

    override suspend fun goToMovies() {
        navigate("movies")
    }

    override suspend fun goToMovieDetails(movieId: Int) {
        navigate("movieDetails/$movieId")
    }
}
