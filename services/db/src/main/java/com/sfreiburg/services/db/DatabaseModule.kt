package com.sfreiburg.services.db

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import comsfreiburgservicesdb.MovieQueries
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.requery.android.database.sqlite.RequerySQLiteOpenHelperFactory

@Module @InstallIn(SingletonComponent::class) interface DatabaseModule {
    companion object {
        private const val DATABASE_FILENAME = "test.db"

        @Provides
        fun providesSqlDriver(@ApplicationContext context: Context): SqlDriver = AndroidSqliteDriver(
            schema = Database.Schema,
            context = context,
            name = DATABASE_FILENAME,
            factory = RequerySQLiteOpenHelperFactory()
        )

        @Provides
        fun providesDatabase(sqlDriver: SqlDriver) = Database(driver = sqlDriver)

        @Provides
        fun providesMovieQueries(database: Database): MovieQueries = database.movieQueries
    }
}
