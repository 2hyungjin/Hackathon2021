package com.example.hackathon2021.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathon2021.data.Board
import com.example.hackathon2021.util.RetrofitConfig
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val postRetrofit = RetrofitConfig.postRetrofit
    val getBoardsRes = MutableLiveData<List<Board>>()
    fun getBoards() {
        viewModelScope.launch {
            postRetrofit.get().let {
                if (it.isSuccessful) {
                    Log.d("main", it.body()?.data.toString())
                    getBoardsRes.postValue(it.body()?.data!!)
                } else {
                    Log.d("main", it.errorBody().toString())
                }
            }
        }
    }

}