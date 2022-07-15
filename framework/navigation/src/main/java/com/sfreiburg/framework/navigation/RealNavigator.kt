package com.sfreiburg.framework.navigation

import androidx.navigation.NavHostController
import com.sfreiburg.routes.Routes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun NavHostController.toNavigator(): Navigator = RealNavigator(this)

class RealNavigator(private val navHostController: NavHostController) : Navigator {

    override suspend fun goToMovies() {
        withContext(Dispatchers.Main) {
            navHostController.navigate(Routes.NoArgRoutes.MoviesRoute.path) {
                popUpTo(Routes.NoArgRoutes.SplashRoute.path) {
                    inclusive = true
                }
            }
        }
    }

    override suspend fun goToMovieDetails(movieId: Int) {
        withContext(Dispatchers.Main) {
            navHostController.navigate(Routes.ArgRoutes.MovieDetailsRoute.buildPath(movieId))
        }
    }
}
