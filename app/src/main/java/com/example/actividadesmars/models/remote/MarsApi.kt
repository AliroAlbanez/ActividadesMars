package com.example.actividadesmars.models.remote

import retrofit2.Response
import retrofit2.http.GET

interface MarsApi {
    @GET("realestate")
    suspend fun fecthMarsList(): List<MarsApiClass>

}