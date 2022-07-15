package com.sfreiburg.repos

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module @InstallIn(SingletonComponent::class) interface RepoModule {
    @Binds
    fun bindsMovieRepo(realMovieRepo: RealMovieRepo): MovieRepo
}
