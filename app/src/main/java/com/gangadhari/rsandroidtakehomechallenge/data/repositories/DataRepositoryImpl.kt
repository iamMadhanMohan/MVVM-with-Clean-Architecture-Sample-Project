package com.gangadhari.rsandroidtakehomechallenge.data.repositories

import com.gangadhari.rsandroidtakehomechallenge.data.local.DriverDao
import com.gangadhari.rsandroidtakehomechallenge.data.local.RouteDao
import com.gangadhari.rsandroidtakehomechallenge.data.mappers.DriverMapper
import com.gangadhari.rsandroidtakehomechallenge.data.mappers.RouteMapper
import com.gangadhari.rsandroidtakehomechallenge.data.remote.RemoteDataSource
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Driver
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Route
import com.gangadhari.rsandroidtakehomechallenge.domain.repositories.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val driverDao: DriverDao,
    private val routeDao: RouteDao,
    private val driverMapper: DriverMapper,
    private val routeMapper: RouteMapper
) : DataRepository {

    override suspend fun fetchAndSaveData() {
        val data = remoteDataSource.fetchData()
        driverDao.insertAll(data.drivers.map { driverMapper.mapToEntity(it) })
        routeDao.insertAll(data.routes.map { routeMapper.mapToEntity(it) })
    }

    override fun getDrivers(): Flow<List<Driver>> =
        driverDao.getAllDrivers().map { it.map { driverMapper.mapToDomain(it) } }

    override fun getRoutes(): Flow<List<Route>> =
        routeDao.getAllRoutes().map{ it.map{routeMapper.mapToDomain(it)} }
}
