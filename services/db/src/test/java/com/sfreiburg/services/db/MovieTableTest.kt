package com.sfreiburg.services.db

import com.google.common.truth.Truth.assertThat
import com.sfreiburg.services.db.DatabaseModule.Companion.providesDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import comsfreiburgservicesdb.Movie
import org.junit.Before
import org.junit.Test

class MovieTableTest {

    private lateinit var driver: SqlDriver
    private lateinit var db: Database

    private val movie =
        Movie(
            id = 1,
            title = "Spiderman",
            overview = "Spiderman saves people",
            backdrop_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
            poster_url = "https://image.tmdb.org/t/p/w780/kqjL17yufvn9OVLyXYpvtyrFfak.jpg",
        )

    @Before
    fun before() {
        driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        Database.Schema.create(driver)
        db = providesDatabase(driver)
    }

    @Test
    fun insertWorks() {
        // given
        // when
        db.movieQueries.insertMovie(movie)

        // then
        assertThat(db.movieQueries.selectAll().executeAsList().first()).isEqualTo(movie)
    }

    @Test
    fun selectAllWorks() {
        // given
        val movie1 = movie
        val movie2 = movie.copy(id = 2)

        // when
        db.movieQueries.insertMovie(movie1)
        db.movieQueries.insertMovie(movie2)

        // then
        val movies = db.movieQueries.selectAll().executeAsList()
        assertThat(movies[0]).isEqualTo(movie1)
        assertThat(movies[1]).isEqualTo(movie2)
    }

    @Test
    fun selectByIdWorks() {
        // given
        val movie1 = movie
        val movie2 = movie.copy(id = 2)

        // when
        db.movieQueries.insertMovie(movie1)
        db.movieQueries.insertMovie(movie2)

        // then
        val movie = db.movieQueries.selectById(2).executeAsOne()
        assertThat(movie).isEqualTo(movie2)
    }

    @Test
    fun deleteAllWorks() {
        // given
        val movie1 = movie
        val movie2 = movie.copy(id = 2)
        db.movieQueries.insertMovie(movie1)
        db.movieQueries.insertMovie(movie2)

        // when
        db.movieQueries.deleteAll()

        // then
        assertThat(db.movieQueries.count().executeAsOne()).isEqualTo(0)
    }

    @Test
    fun countWorks() {
        // given
        // when
        db.movieQueries.insertMovie(movie)

        // then
        assertThat(db.movieQueries.count().executeAsOne()).isEqualTo(1)
    }
}
