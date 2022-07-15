package com.sfreiburg.composables

import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import com.sfreiburg.models.Movie
import org.junit.Rule
import org.junit.Test

class MovieDetailsSnapshotTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5,
        theme = "android:Theme.Material.Light.NoActionBar"
    )

    @Test
    fun default() {
        paparazzi.snapshot {
            MovieDetails(
                movie =
                Movie(
                    id = 1,
                    title = "Spiderman",
                    overview = "Spiderman saves people",
                    backdrop_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
                    poster_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
                ),
            )
        }
    }
}
