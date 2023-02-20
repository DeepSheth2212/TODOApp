package com.example.todoapp.Repository

import com.example.todoapp.Network.UserApi
import com.example.todoapp.models.UserRequest
import com.example.todoapp.models.UserResponse
import retrofit2.Response


class UserRepository (private val userApi: UserApi){
    suspend fun login(userRequest: UserRequest) : Response<UserResponse> = userApi.login(userRequest)
}