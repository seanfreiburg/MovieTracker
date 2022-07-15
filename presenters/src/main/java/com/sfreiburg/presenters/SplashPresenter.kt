package com.sfreiburg.presenters

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.sfreiburg.framework.navigation.Navigator
import com.sfreiburg.framework.presenters.MavericksPresenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

data class SplashViewModel(val count: Int = 0)

data class SplashState(val count: Int = 0) : MavericksState

sealed class SplashEvent {
    data class OnInit(val navigator: Navigator) : SplashEvent()
}

class SplashPresenter @AssistedInject constructor(
    @Assisted initialState: SplashState,
) : MavericksPresenter<SplashState, SplashEvent, SplashViewModel>(initialState) {

    override fun onEvent(event: SplashEvent) {
        when (event) {
            is SplashEvent.OnInit -> {
                viewModelScope.launch { event.navigator.goToMovies() }
            }
        }
    }

    override fun SplashState.reduce(): SplashViewModel {
        return SplashViewModel(count = count)
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<SplashPresenter, SplashState> {
        override fun create(state: SplashState): SplashPresenter
    }

    companion object : MavericksViewModelFactory<SplashPresenter, SplashState> by hiltMavericksViewModelFactory()
}
