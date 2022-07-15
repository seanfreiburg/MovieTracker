package com.sfreiburg.routes

sealed class Routes {
    sealed class NoArgRoutes(open val path: String) : Routes() {
        object SplashRoute : NoArgRoutes("splash")
        object MoviesRoute : NoArgRoutes("movies")
    }

    sealed class ArgRoutes : Routes() {
        object MovieDetailsRoute : ArgRoutes() {
            val path = "movieDetails/{movieId}"
            val movieIdArg = "movieId"

            fun buildPath(movieId: Int) = "movieDetails/$movieId"
        }
    }
}
