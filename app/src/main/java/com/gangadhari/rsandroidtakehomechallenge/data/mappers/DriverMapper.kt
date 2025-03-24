package com.gangadhari.rsandroidtakehomechallenge.data.mappers


import com.gangadhari.rsandroidtakehomechallenge.data.local.entities.DriverEntity
import com.gangadhari.rsandroidtakehomechallenge.data.remote.dtos.DriverDto
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Driver
import javax.inject.Inject

class DriverMapper @Inject constructor(){
    fun mapToDomain(entity: DriverEntity): Driver = Driver(entity.id, entity.name)
    fun mapToEntity(dto: DriverDto): DriverEntity = DriverEntity(dto.id, dto.name)
}
