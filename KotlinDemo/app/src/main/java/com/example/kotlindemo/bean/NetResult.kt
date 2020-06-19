package com.example.kotlindemo.bean

data class  NetResult<T>(val data:T, val errorCode:Int, val errorMsg:String)