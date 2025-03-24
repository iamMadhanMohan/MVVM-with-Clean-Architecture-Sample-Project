package com.gangadhari.rsandroidtakehomechallenge.domain.repositories

import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Driver
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Route
import kotlinx.coroutines.flow.Flow


interface DataRepository {
    suspend fun fetchAndSaveData()
    fun getDrivers(): Flow<List<Driver>>
    fun getRoutes(): Flow<List<Route>>
}