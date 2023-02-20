package com.example.todoapp.Network

import com.example.todoapp.models.UserRequest
import com.example.todoapp.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

// https://reqres.in/api/
interface UserApi {
    @POST("login")
    suspend fun login(
        @Body userRequest: UserRequest
    ): Response<UserResponse>
}