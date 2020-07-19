package com.example.kotlindemo.test

class TestInit() {

    var isLoading =false

    constructor(isLoading:Boolean):this(){
        println("构造方法")
    }
    init {
        println("init方法  --- 1")
    }

    init {
        println("init方法  --- 2")
    }
}

fun main() {
    TestInit(true)
}