package com.example.kotlindemo.api

import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.bean.RegisterResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @POST("/user/login")
    @FormUrlEncoded
    fun login(@Field("username") username: String, @Field("password") password: String):Observable<Result<LoginResponse>>


    @POST("/user/register")
    @FormUrlEncoded
    fun register(@Field("username") username: String, @Field("password") password: String,
                 @Field("repassword") repassword: String):Observable<Result<RegisterResponse>>


}