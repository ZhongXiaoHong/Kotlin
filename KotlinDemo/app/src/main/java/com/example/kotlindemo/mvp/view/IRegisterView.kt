package com.example.kotlindemo.mvp.view

import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.mvp.view.IView

interface IRegisterView:IView {

    fun RegisterSuccess(data: LoginResponse)

    fun RegisterFailed(data:String)

}
