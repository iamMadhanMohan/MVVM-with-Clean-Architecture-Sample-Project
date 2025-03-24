package com.gangadhari.rsandroidtakehomechallenge.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gangadhari.rsandroidtakehomechallenge.data.local.entities.DriverEntity
import com.gangadhari.rsandroidtakehomechallenge.data.local.entities.RouteEntity

@Database(entities = [DriverEntity::class, RouteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun driverDao(): DriverDao
    abstract fun routeDao(): RouteDao
}