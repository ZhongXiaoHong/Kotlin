package com.example.kotlindemo.coroutine

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    @GET("users/{login}")
    fun getUser(@Path("login") login: String):Call<GUser>// Deferred<GUser>





    @GET("https://www.baidu.com/")
    fun baidu():Deferred<ResponseBody>
}


