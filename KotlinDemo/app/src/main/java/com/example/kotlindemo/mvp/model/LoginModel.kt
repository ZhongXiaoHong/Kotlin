package com.example.kotlindemo.mvp.model

import android.widget.Toast
import com.example.kotlindemo.api.Api
import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.bean.RegisterResponse
import com.example.kotlindemo.mvp.presenter.ILoginPresenter
import com.example.kotlindemo.net.MyParseOperator
import com.example.kotlindemo.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModel :ILoginModel {

    override fun login(name: String, pwd: String, listener: ILoginListener) {

        NetManager.creatService(Api::class.java)
            .login(name, pwd)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MyParseOperator<LoginResponse>() {

                override fun onSuccess(data: LoginResponse) {

                    listener.onLoginSuccess(data)
                }

                override fun onFailed(msg: String) {

                    listener.onLoginFailed(msg)
                }

            })
    }


    override fun register( username: String, password: String,
                  repassword: String,listener:IRegisterListener){

        NetManager.creatService(Api::class.java)
            .register(username, password,repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MyParseOperator<RegisterResponse>() {

                override fun onSuccess(data: RegisterResponse) {

                    listener.onRegisterSuccess(data)
                }

                override fun onFailed(msg: String) {

                    listener.onRegisterFailed(msg)
                }

            })
    }

    override fun cancelRequest() {
        TODO("Not yet implemented")
    }
}