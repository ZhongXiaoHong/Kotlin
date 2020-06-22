package com.example.kotlindemo.mvp.presenter

import com.example.kotlindemo.mvp.view.ILoginView

interface  ILoginPresenter:IBasePresent{

    fun loginAction(name:String,pw :String)
}