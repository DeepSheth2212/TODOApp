package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.Network.RetroFitBuilder
import com.example.todoapp.Repository.UserRepository
import com.example.todoapp.ViewModel.UserViewModel
import com.example.todoapp.ViewModel.UserViewModelFactory
import com.example.todoapp.models.UserRequest
import com.github.ybq.android.spinkit.style.Wave

class LoginActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    lateinit var userViewModelFactory: UserViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.txt_email)
        val passwordEditText = findViewById<EditText>(R.id.txt_password)
        val loginButton = findViewById<Button>(R.id.btn_login)
        val progressBar  = findViewById<ProgressBar>(R.id.progress_bar)
        val userApi = RetroFitBuilder.api
        val userRepository = UserRepository(userApi)
        userViewModelFactory = UserViewModelFactory(userRepository)
        userViewModel = ViewModelProvider(this , userViewModelFactory)[UserViewModel::class.java]

        loginButton.setOnClickListener {
            val email_txt = emailEditText.text.toString()
            val pass_txt = passwordEditText.text.toString()
            val wave = Wave()
            progressBar.indeterminateDrawable = wave
            progressBar.visibility = View.VISIBLE

            userViewModel.login(UserRequest(email_txt,pass_txt))
            userViewModel.userResponse.observe(this) {
                if(it==null){
                    Toast.makeText(this , "User not found!" , Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
                else{
                    startActivity(Intent(this,MainActivity::class.java))
                    //Log.d("deep","Login at activity: ${it}")
                    finish()
                }

            }


        }





    }
}
