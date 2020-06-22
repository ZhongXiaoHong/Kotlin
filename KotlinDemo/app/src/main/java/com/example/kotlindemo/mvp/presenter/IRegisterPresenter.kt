package com.example.kotlindemo.mvp.presenter

import retrofit2.http.Field

interface IRegisterPresenter:IBasePresent{

    fun register( username: String, password: String,
  repassword: String)
}
