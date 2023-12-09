package com.dicoding.kulinerku.data.remote.retrofit

import com.dicoding.kulinerku.data.remote.response.LoginResponse
import com.dicoding.kulinerku.data.remote.response.RegisterResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("firstname") firstname: String,
        @Field("lastname") lastname: String,
        @Field("email") email: String,
        @Field("phonenumber") phonenumber: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse
}