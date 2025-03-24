package com.gangadhari.rsandroidtakehomechallenge.data.mappers


import com.gangadhari.rsandroidtakehomechallenge.data.local.entities.RouteEntity
import com.gangadhari.rsandroidtakehomechallenge.data.remote.dtos.RouteDto
import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Route
import javax.inject.Inject

class RouteMapper @Inject constructor(){
    fun mapToDomain(entity: RouteEntity): Route = Route(entity.id, entity.name, entity.type)
    fun mapToEntity(dto: RouteDto): RouteEntity = RouteEntity(dto.id, dto.name, dto.type)
}
