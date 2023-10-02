package com.example.task_21_hometask_depinj_hilt

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

// dlya dagger
//@Singleton

class ApiClient @Inject constructor(){
    val client = Retrofit.Builder()
    .baseUrl("https://akabab.github.io/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}