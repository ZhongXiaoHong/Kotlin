package com.example.kotlindemo.net

import com.example.kotlindemo.api.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.example.kotlindemo.bean.LoginResponse
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


//TODO 实现类似Java的静态内部类单例
class NetManager {

    var client:Retrofit?=null

    object Holder {
        val instance = NetManager()
    }

    companion object {
        fun getInstance(): NetManager = Holder.instance

        fun <T> creatService(clazz:Class<T>):T{

            return  getInstance().client!!.create(clazz)
        }

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



}



