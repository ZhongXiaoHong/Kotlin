package com.example.kotlindemo.gaojie


fun main() {


    loginAction("luoxiaoling", "888168") { name, pwd ->
        kotlin.io.println("我是第1个调用高阶函数的地方$name$pwd")
    }

    run {  }

}
typealias  Method = (String, String) -> Unit
//
//  fun loginAction(name:String,pwd:String,method:(String,String)->Unit ){
//      method(name,pwd)
//  }

fun loginAction(name: String, pwd: String, method: Method) {
    method(name, pwd)
}

