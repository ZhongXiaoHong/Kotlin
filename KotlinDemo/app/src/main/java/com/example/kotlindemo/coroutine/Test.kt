package com.example.kotlindemo.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log

val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(msg: Any?) = println("${now()} [${Thread.currentThread().name}] $msg")


suspend fun main() {

    log("D1")
    //TODO 使用默认的启动模式
    //TODO 没有指定调度器，使用默认调度器，
    //TODO 会在后台开一个线程池来处理异步任务
    val job = GlobalScope.launch {
        log("D2")
    }
    log("D3")
    job.join()
    log("D4")

    println()
    println ()


    log("L1")
    //TODO 懒汉模式启动，
    //TODO launch之后不会有任何调度行为，协程体不执行
    val jobLazy = GlobalScope.launch(start = CoroutineStart.LAZY) {
        log("L2")
    }
    log("L3")
    jobLazy.start()//TODO 主动触发协程的调度执行
    //jobLazy.join()  //TODO 隐式的触发协程的调度执行
    log("L4")

    println()
    println ()


    log("A1")
    val jobA = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
        log("A2")
    }
    //TODO 协程后立即 cancel,
    //TODO 由于是 ATOMIC 模式，因此协程一定会被调度
    //TODO 但是A2、A3输出顺序不定
    jobA.cancel()
    log("A3")


    println()
    println ()


    log("D1")
    val jobD2 = GlobalScope.launch(start = CoroutineStart.DEFAULT) {
        log("D2")
    }
    //TODO D2 可能会输出，可能不会输出
    //TODO 如果第一次调度协程时，cancel已经调用则不输出
    //TODO 如果协程已经开始尚未被cancel则输出
    //TODO  注意与ATOMIC对比，ATOMIC是一定会输出
    jobA.cancel()
    log("D3")


    println()
    println ()

    //TODO 调用cancel时会把job的状态设置成cancelling
    //TODO TOMIC模式会在协程启动时无视这一状态，直到遇到第一个挂起点
    //TODO  第一个挂起点之后协程体任务的可以取消
    log("A1")
    val jobA2 = GlobalScope.launch(start = CoroutineStart.ATOMIC) {
        log("A2")
        //TODO 第一个挂起点，并且delay是suspend函数
        // TODO 支持cancel，A3 不会被打印
        delay(1000)
        log("A3")
    }
    job.cancel()
    log("A4")
    job.join()

    println()
    println ()


    log("U1")
    //TODO UNDISPATCHED 不经过任何调度器即开始执行协程体
    //TODO 直接在当前线程下执行直到遇到第一个挂起点
    val jobU = GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
        log("U2")
        delay(100)
        log("U3")
    }
    log("U4")
    //TODO 要求等待协程执行完
    jobU.join()
    log("U5")

}