package com.example.todoapp.ViewModel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.LoginActivity
import com.example.todoapp.Repository.UserRepository
import com.example.todoapp.models.UserRequest
import com.example.todoapp.models.UserResponse
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val userResponse : MutableLiveData<UserResponse> = MutableLiveData()
    fun login(userRequest : UserRequest){
        viewModelScope.launch {
            val response = userRepository.login(userRequest)
            userResponse.value = response.body()
        }
    }
}