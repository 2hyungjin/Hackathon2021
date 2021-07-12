package com.example.hackathon2021.dao

import com.example.hackathon2021.data.*
import retrofit2.Response
import retrofit2.http.*

interface AccountRetrofit {
    @POST("auth/login")
    suspend fun login(
        @Body
        account: Account
    ): Response<Res<LoginResponse>>

    @GET("school/search-school")
    suspend fun searchSchool(
        @Query("query") name: String
    ): Response<Res<List<ResSearchSchool>>>

    @POST("auth/signup")
    suspend fun signUp(
        @Body
        req: ReqSignUp
    ): Response<Res<Any>>

    @GET("auth/exist")
    suspend fun idCheck(@Query("id") id: String): Response<Res<Any>>
}