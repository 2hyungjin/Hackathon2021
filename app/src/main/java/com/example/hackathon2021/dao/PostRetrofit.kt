package com.example.hackathon2021.dao

import com.example.hackathon2021.data.Board
import com.example.hackathon2021.data.req.ReqPost
import com.example.hackathon2021.data.res.Res
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostRetrofit {
    @POST("post")
    suspend fun post(
        @Body
        reqPost: ReqPost
    ): Response<Res<Any>>

    @GET("post")
    suspend fun get():Response<Res<List<Board>>>
}