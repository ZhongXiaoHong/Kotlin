package com.example.kotlindemo.mvp.presenter

import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.mvp.model.ILoginListener
import com.example.kotlindemo.mvp.model.ILoginModel
import com.example.kotlindemo.mvp.model.LoginModel
import com.example.kotlindemo.mvp.view.ILoginView

class LoginPresenter(private val view:ILoginView) : ILoginPresenter,ILoginListener{

    private  var model:ILoginModel = LoginModel()



    override fun loginAction(name: String, pw: String) {

        model.login(name,pw,this)

    }

    override fun onLoginSuccess(data: LoginResponse) {
        TODO("Not yet implemented")
        view.loginSuccess(data)
    }

    override fun onLoginFailed(msg: String) {
        TODO("Not yet implemented")
        view.loginFailed(msg)
    }


}