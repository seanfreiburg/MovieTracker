package com.sfreiburg.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.airbnb.mvrx.compose.mavericksViewModel
import com.sfreiburg.composables.Splash
import com.sfreiburg.framework.navigation.Navigator
import com.sfreiburg.framework.presenters.collectViewModelsAsState
import com.sfreiburg.presenters.SplashEvent
import com.sfreiburg.presenters.SplashPresenter

@Composable
fun SplashScreen(
    navigator: Navigator,
) {
    val presenter: SplashPresenter = mavericksViewModel()
    val viewModel by presenter.collectViewModelsAsState()

    LaunchedEffect(Unit) {
        presenter.onEvent(SplashEvent.OnInit(navigator))
    }
    AppThemeFullScreenWrapper { Splash() }
}
