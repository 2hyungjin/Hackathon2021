package com.example.hackathon2021.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathon2021.data.Account
import com.example.hackathon2021.data.LoginResponse
import com.example.hackathon2021.util.RetrofitConfig
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val accountRetrofit = RetrofitConfig.accountRetrofit

    val loginRes=MutableLiveData<LoginResponse>()

    fun login(account: Account) {
        viewModelScope.launch {
            accountRetrofit.login(account).let {
                if (it.isSuccessful) {
                    Log.d("login", it.body()!!.data.authToken)
                } else {
                    Log.d("login", it.body()!!.message)
                    Log.d("login", it.body()!!.status)
                }
            }
        }
    }
}