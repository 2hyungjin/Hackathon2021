package com.example.hackathon2021.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathon2021.data.ReqSignUp
import com.example.hackathon2021.data.Res
import com.example.hackathon2021.util.RetrofitConfig
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    private val accountRetrofit = RetrofitConfig.accountRetrofit

    val idCheckRes = MutableLiveData<Res<Any>>()
    val signUpRes = MutableLiveData<Res<Any>>()

    fun idCheck(id:String){
        viewModelScope.launch {
            accountRetrofit.idCheck(id).let {
                if (it.isSuccessful){
                    idCheckRes.postValue(it.body())
                }else{
                    Log.d("SignUp", it.body()!!.status.toString())
                    Log.d("SignUp", it.body()!!.message)
                }
            }
        }
    }
    fun signUp(req: ReqSignUp) {
        viewModelScope.launch {
            accountRetrofit.signUp(req).let {
                if (it.isSuccessful) {
                    signUpRes.postValue(it.body())
                } else {
                    Log.d("SignUp", it.body()!!.status.toString())
                    Log.d("SignUp", it.body()!!.message)
                }
            }
        }
    }
}