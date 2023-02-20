package com.example.todoapp.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val url = "https://reqres.in/api/"
object RetroFitBuilder {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : UserApi by lazy{
        retrofit.create(UserApi::class.java)
    }
}