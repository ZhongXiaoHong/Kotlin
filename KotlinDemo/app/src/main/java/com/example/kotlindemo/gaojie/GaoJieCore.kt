package com.example.kotlindemo.gaojie


fun main() {


//    loginAction("luoxiaoling", "888168") { name, pwd ->
//        kotlin.io.println("我是第1个调用高阶函数的地方$name$pwd")
//    }
//
//    GaoJieCore().doAnotherSth()
//    GaoJieCore().doSth()

//    var a = 100
//    a.justRun()
//    var b = GaoJieCore()
//    b.justRun()


//    var a = 100
//    a.justRun2(a)
//    var b = GaoJieCore()
//    b.justRun2("GaoJieCore")

//    var a = 100
//    a.justRun3(){
//        true
//    }
//    var b = GaoJieCore()
//    b.justRun3(){
//        10086
//    }

    var a = 100
    a.justRun4(){
        compareTo(20)
        true
    }
    var b = GaoJieCore()
    b.justRun4(){
        doSth()
        10086
    }



}

fun <T,R> T.justRun4(method:T.()->R){
    println("justRun4 ${method()}")
}


 fun <T,R> T.justRun3(method:()->R){
    println("justRun3 ${method()}")
}

fun <T> T.justRun(){
    println("justrun")
}

fun <T,R> T.justRun2(param:R){
    println("justRun2$param")
}







typealias  Method = (String, String) -> Unit
//
//  fun loginAction(name:String,pwd:String,method:(String,String)->Unit ){
//      method(name,pwd)
//  }

fun loginAction(name: String, pwd: String, method: Method) {
    method(name, pwd)
}

fun GaoJieCore.doAnotherSth(){
    println("GaoJieCore---doAnotherSth")
}


class  GaoJieCore{

    fun doSth(){
        println("GaoJieCore---dosth")
    }
}




