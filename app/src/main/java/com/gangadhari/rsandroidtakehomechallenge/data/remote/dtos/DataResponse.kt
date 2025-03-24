package com.gangadhari.rsandroidtakehomechallenge.data.remote.dtos

data class DataResponse(
    val drivers: List<DriverDto>,
    val routes: List<RouteDto>
)
