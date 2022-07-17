package com.sfreiburg.movietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sfreiburg.framework.navigation.toNavigator
import com.sfreiburg.routes.Routes
import com.sfreiburg.screens.AppThemeFullScreenWrapper
import com.sfreiburg.screens.MovieDetailsScreen
import com.sfreiburg.screens.MoviesScreen
import com.sfreiburg.screens.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTrackerApp()
        }
    }
}

@Composable
private fun MovieTrackerApp() {
    AppThemeFullScreenWrapper {
        val navController = rememberNavController()
        val navigator = navController.toNavigator()

        NavHost(
            navController = navController, startDestination = Routes.NoArgRoutes.SplashRoute.path
        ) {
            composable(Routes.NoArgRoutes.SplashRoute.path) { SplashScreen(navigator) }
            composable(Routes.NoArgRoutes.MoviesRoute.path) { MoviesScreen(navigator) }
            dialog(
                Routes.ArgRoutes.MovieDetailsRoute.path,
                arguments = listOf(
                    navArgument(Routes.ArgRoutes.MovieDetailsRoute.movieIdArg) {
                        type = NavType.IntType
                    }
                )
            ) { backStackEntry ->
                MovieDetailsScreen(
                    navigator = navigator,
                    movieId = backStackEntry.arguments!!.getInt(
                        Routes.ArgRoutes.MovieDetailsRoute.movieIdArg
                    )
                )
            }
        }
    }
}
