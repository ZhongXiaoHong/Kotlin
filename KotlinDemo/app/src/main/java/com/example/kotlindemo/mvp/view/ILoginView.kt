package com.example.kotlindemo.mvp.view

import com.example.kotlindemo.bean.LoginResponse

interface ILoginView{

    fun loginSuccess(data:LoginResponse)

    fun loginFailed(data:String)

}