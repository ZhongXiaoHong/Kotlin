package com.example.kotlindemo.mvp.model

import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.bean.RegisterResponse
import com.example.kotlindemo.mvp.view.ILoginView

interface ILoginModel{

    fun login(
        name:String,
        pwd:String,
        listener: ILoginListener
    )

    fun register( username: String, password: String,
                  repassword: String,listener:IRegisterListener)

    fun cancelRequest();
}

interface  ILoginListener{

    fun onLoginSuccess(data:LoginResponse)

    fun onLoginFailed(msg:String)

}


interface  IRegisterListener{

    fun onRegisterSuccess(data:RegisterResponse)

    fun onRegisterFailed(msg:String)

}