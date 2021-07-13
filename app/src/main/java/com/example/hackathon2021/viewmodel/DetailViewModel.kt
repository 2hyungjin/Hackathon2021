package com.example.hackathon2021.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackathon2021.dao.PostRetrofit
import com.example.hackathon2021.data.Comment
import com.example.hackathon2021.util.RetrofitConfig
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val postRetrofit:PostRetrofit=RetrofitConfig.postRetrofit
    val resGetComments=MutableLiveData<List<Comment>>()

    fun getComments(boardId:Int){
        viewModelScope.launch {
            postRetrofit.getComments(boardId).let {
                if (it.isSuccessful){
                    resGetComments.postValue(it.body()?.data!!)
                }else{
                    Log.d("detail",it.errorBody().toString())
                }
            }

        }
    }
}