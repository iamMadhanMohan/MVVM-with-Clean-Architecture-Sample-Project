package com.gangadhari.rsandroidtakehomechallenge.domain.usecases


import com.gangadhari.rsandroidtakehomechallenge.domain.entities.Route
import com.gangadhari.rsandroidtakehomechallenge.domain.repositories.DataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRoutesUseCase @Inject constructor(private val repository: DataRepository) {

    operator fun invoke(driverId: Int): Flow<List<Route>> {
        return repository.getRoutes().map { routes ->
            routes.filter { route ->
                when {
                    route.id == driverId -> true
                    driverId % 2 == 0 && route.type == "R" -> true
                    driverId % 5 == 0 && route.type == "C" -> true
                    else -> route.type == "I"
                }
            }
        }
    }
}