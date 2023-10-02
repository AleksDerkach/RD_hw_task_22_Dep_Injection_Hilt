package com.example.task_21_hometask_depinj_hilt

import retrofit2.Response
import retrofit2.Retrofit

class Repository(private val client: ApiClient) {
    suspend fun getSuperHero() : Response<List<SuperHero>>{
        val apiInterface = client.client.create(ApiInterface::class.java)
        return apiInterface.getSuperHero()
    }
}