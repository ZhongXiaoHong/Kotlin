package com.example.kotlindemo.mvp.presenter

import com.example.kotlindemo.bean.RegisterResponse
import com.example.kotlindemo.mvp.model.IRegisterListener
import com.example.kotlindemo.mvp.model.LoginModel
import com.example.kotlindemo.mvp.view.IRegisterView

class RegisterPresenter(private var view:IRegisterView):IRegisterPresenter,IRegisterListener {

    private var model = LoginModel()

    override fun register(username: String, password: String, repassword: String) {
        model.register(username,password,repassword,this)
    }

    override fun attachView() {
        TODO("Not yet implemented")
    }

    override fun unAttachView() {

        model.cancelRequest()

    }

    override fun onRegisterSuccess(data: RegisterResponse) {
        TODO("Not yet implemented")
    }

    override fun onRegisterFailed(msg: String) {
        TODO("Not yet implemented")
    }

}
