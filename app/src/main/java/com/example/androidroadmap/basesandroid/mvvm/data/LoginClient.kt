package com.example.androidroadmap.basesandroid.mvvm.data

import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {

    @GET("/v3/2571a2b4-0266-48c7-a421-a9b1596390b0")
    suspend fun doLogin(): Response<LoginResponse>
}
