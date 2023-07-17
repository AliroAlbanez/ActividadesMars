package com.example.actividadesmars.models.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
        fun retrofitInstance():MarsApi{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(MarsApi::class.java)

        }

    }
}