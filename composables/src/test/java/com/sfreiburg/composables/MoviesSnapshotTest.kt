package com.sfreiburg.composables

import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import com.airbnb.mvrx.Success
import com.sfreiburg.models.Movie
import org.junit.Rule
import org.junit.Test

class MoviesSnapshotTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5,
        theme = "android:Theme.Material.Light.NoActionBar"
    )

    @Test
    fun default() {
        paparazzi.snapshot {
            Movies(
                movies = Success(
                    listOf(
                        Movie(
                            id = 1,
                            title = "Spiderman",
                            overview = "Spiderman saves people",
                            backdrop_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
                            poster_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
                        ),
                        Movie(
                            id = 2,
                            title = "title",
                            overview = "body",
                            backdrop_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
                            poster_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
                        )
                    )
                ),
                query = "query",
                onQueryChanged = {},
                onMovieClicked = {}
            )
        }
    }
}
