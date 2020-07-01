package com.example.kotlindemo.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

//fun main() {
//
//
//
//
//
//
//}

fun log(msg:Int){
    println(msg)
}
suspend fun main() {
    log(1)
    val job = GlobalScope.launch {
        log(2)
    }
    log(3)
    job.join()
    log(4)


}