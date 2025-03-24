package com.gangadhari.rsandroidtakehomechallenge.domain.usecases


import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Driver
import com.gangadhari.rsandroidtakehomechallenge.domain.repositories.DataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDriversUseCase @Inject constructor(private val repository: DataRepository) {
    operator fun invoke(): Flow<List<Driver>> = repository.getDrivers()
}