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

    @POST("auth/signin")
    suspend fun signIn(
        @Body
        req: ReqSignIn
    ): Response<Res<Any>>

}