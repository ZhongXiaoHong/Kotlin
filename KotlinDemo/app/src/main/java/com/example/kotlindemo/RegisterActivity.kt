package com.example.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.mvp.presenter.RegisterPresenter
import com.example.kotlindemo.mvp.view.BaseActivity
import com.example.kotlindemo.mvp.view.IRegisterView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.nameEd
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<RegisterPresenter>(),IRegisterView {


    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun creatPresenter(): RegisterPresenter {
        return RegisterPresenter(this)
    }

    override fun recycle() {
        presenter.unAttachView()
    }


    fun register(view: View) {

        presenter.register(nameEd2.text.toString(),pwdEd2.toString().toString(),repwEd2.toString().toString())

    }

    override fun RegisterSuccess(data: LoginResponse) {
      finish()
    }

    override fun RegisterFailed(data: String) {
       Toast.makeText(this@RegisterActivity,"注册失败：$data",Toast.LENGTH_LONG).show()
    }

}


