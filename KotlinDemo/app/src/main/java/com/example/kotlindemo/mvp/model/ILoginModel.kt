package com.example.kotlindemo.mvp.model

import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.mvp.view.ILoginView

interface ILoginModel{

    fun login(
        name:String,
        pwd:String,
        listener: ILoginListener
    )
}

interface  ILoginListener{

    fun onLoginSuccess(data:LoginResponse)

    fun onLoginFailed(msg:String)

}