package com.gangadhari.rsandroidtakehomechallenge.data.remote

import com.gangadhari.rsandroidtakehomechallenge.data.remote.dtos.DataResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchData(): DataResponse = apiService.fetchData()
}