package com.sfreiburg.services.db

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

fun buildFakeDatabase(): Database {
    val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    Database.Schema.create(driver)
    return DatabaseModule.providesDatabase(driver)
}
