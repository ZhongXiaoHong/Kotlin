package com.example.kotlindemo.net

import com.example.kotlindemo.api.Api
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.example.kotlindemo.bean.LoginResponse


//TODO 实现类似Java的静态内部类单例
class NetManager {

    var client:Retrofit?=null

    object Holder {
        val instance = NetManager()
    }

    companion object {
        fun getInstance(): NetManager = Holder.instance
    }

    fun <T> creatService(clazz:Class<T>):T{

       return  client!!.create(clazz)
    }




 class Builder {

        var baseUrl: String? = null

        fun setBaseUrl(url: String): Builder {

            baseUrl = url
            return this
        }

        fun build(){

            var client = OkHttpClient().newBuilder().build()

            var retrofit =   Retrofit.Builder()
                .baseUrl(baseUrl?:"")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

            NetManager.getInstance().client = retrofit
        }




    }


}


fun main(){

    NetManager.Builder().setBaseUrl("https://www.wanandroid.com").build()

    var  api = NetManager.getInstance().creatService(Api::class.java)






    api.login("luoxiaoling","888168")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(object : MyParseOperater<LoginResponse>() {

            override fun onSuccess(data: LoginResponse) {

                println("onsuccess = $data")
            }

            override fun onFailed(msg: String) {
                println("onsuccess = $msg")
            }

        })



}



