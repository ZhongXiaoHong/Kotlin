package com.example.kotlindemo.java_kotlin_community

fun main() {

    testGaoJie(false){//注意这个是函数调用的时候在加花括号，
        println(it)
        if(it=="flag ==  true"){
            //TODO 返回方法结果
            "OK"
        }else{
            "NO"
        }
    }
}

//TODO method:(String)->Unit
//表示method是方法名
//String 是形参类型
//Unit 返回类型
fun testGaoJie(flag:Boolean,method:(String)->String){

    if (flag){
        //TODO 调用方法之后返回计算结果
        var result = method("flag ==  true")
        println(result)
    }else{
        var result = method("flag ==  false")
        println(result)
    }
}