package com.example.kotlindemo.mvp.presenter

import com.example.kotlindemo.mvp.view.IView

interface IBasePresent {

    fun attachView()

    fun unAttachView()
}