package com.example.kotlindemo.test


fun main() {

    dosth("小明"){
        18
    }
}

fun dosth(name:String,method:(String)->Int){

    var age = method(name)

    println("${name}的年龄=$age")

}