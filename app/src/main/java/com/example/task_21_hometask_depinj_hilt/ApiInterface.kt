package com.example.task_21_hometask_depinj_hilt


import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/superhero-api/api/all.json")
    suspend fun getSuperHero(): Response <List<SuperHero>>
    //fun getSuperHero(): Single<SuperHeroResponse>
}