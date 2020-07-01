package com.example.kotlindemo.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import com.example.kotlindemo.R
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import kotlin.concurrent.thread

class CoroutineActivity : AppCompatActivity() {

    val baseUrl = "https://api.github.com/"   //"https://www.baidu.com/"  //

    val githubService by lazy {

        val retrofit =  retrofit2.Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
           .addCallAdapterFactory(CoroutineCallAdapterFactory())//TODO 协程使用retrofit 增加接口调用返回结果转换  Call<T>---->Deferred<T>
            .build()

        retrofit.create(GithubApi::class.java)


    }
    //TODO  kotlin 使用java类并且要重写方法的时候要加object:

    val handler = object: Handler(){

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            textViewResult.setText(msg.obj as String)
        }

    }

    val myThread =  thread {

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)


    }

    //TODO 没有使用协程请求网络
    fun getUser(view: View) {

//        githubService.getUser("zhongxiaohong")
//            .enqueue(object : Callback<GUser> {
//                override fun onFailure(call: Call<GUser>, t: Throwable) {
//
//                    var msg = Message.obtain()
//                    msg.obj = t.toString()
//                    handler.sendMessage(msg)
//                }
//
//                override fun onResponse(call: Call<GUser>, response: Response<GUser>) {
//                    var msg = Message.obtain()
//                    msg.obj = response.body()?.name?:"空的"
//                    handler.sendMessage(msg)
//                }
//
//            })

    }

    //TODO 使用协程请求网络
    fun getUser2(view: View) {

        GlobalScope.launch(Dispatchers.Main) {

            try {
             //   showSuccess(githubService.getUser("zhongxiaohong").await().name+"***")
                showSuccess(githubService.baidu().await().string())
            }catch (e:Exception){
               showError(e.toString())
            }
        }

    }

    fun showSuccess(msg:String){
        textViewResult.setText(msg)
    }

    fun showError(msg:String){
        textViewResult.setText(msg)
    }


}
