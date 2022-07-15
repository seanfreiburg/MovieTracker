package com.sfreiburg.presenters

import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.airbnb.mvrx.hilt.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface PresentersModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashPresenter::class)
    fun splashViewModelFactory(factory: SplashPresenter.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(MoviesPresenter::class)
    fun moviesViewModelFactory(factory: MoviesPresenter.Factory): AssistedViewModelFactory<*, *>

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailsPresenter::class)
    fun movieDetailsViewModelFactory(factory: MovieDetailsPresenter.Factory): AssistedViewModelFactory<*, *>
}
