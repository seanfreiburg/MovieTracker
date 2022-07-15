/*
package com.sfreiburg.presenters

import com.airbnb.mvrx.test.MvRxTestRule
import com.sfreiburg.framework.navigation.FakeNavigator
import com.sfreiburg.repos.FakeAuthRepo
import com.sfreiburg.routes.Routes
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class SplashPresenterTest  {
    @get:Rule
    val mvrxRule = MvRxTestRule()

    private val fakeAuthRepo = FakeAuthRepo()
    private val navigator = FakeNavigator()

    @Test
    fun `SplashPresenter default state is correct`() = runBlocking {
        val presenter = SplashPresenter(
            SplashState(0),
            fakeAuthRepo
        )

        val state = presenter.awaitState()
        Assert.assertEquals(state, SplashState(0))
    }

    @Test
    fun `if isSignedIn, navigates to Home`() = runBlocking {
        fakeAuthRepo.signIn("dummy", "hunter2")
        val presenter = SplashPresenter(
            SplashState(0),
            fakeAuthRepo
        )

        presenter.onEvent(navigator, SplashEvents.OnInit)

        Assert.assertEquals(Routes.homeRoute, navigator.awaitScreen())
    }

    @Test
    fun `if not isSignedIn, navigates to Login`() = runBlocking {
        fakeAuthRepo.signOut()
        val presenter = SplashPresenter(
            SplashState(0),
            fakeAuthRepo
        )

        presenter.onEvent(navigator, SplashEvents.OnInit)

        Assert.assertEquals(Routes.loginRoute, navigator.awaitScreen())
    }
}*/
