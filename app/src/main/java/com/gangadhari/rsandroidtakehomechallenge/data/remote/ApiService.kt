package com.gangadhari.rsandroidtakehomechallenge.data.remote

import com.gangadhari.rsandroidtakehomechallenge.data.remote.dtos.DataResponse
import retrofit2.http.GET

interface ApiService {
    @GET("data")
    suspend fun fetchData(): DataResponse
}