package com.example.kotlindemo.mvp.view

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.mvp.presenter.IBasePresent

abstract class BaseActivity<P> : AppCompatActivity() where  P : IBasePresent {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init()
        presenter = creatPresenter()
    }

     open fun init() {

    }

    abstract fun getLayoutId(): Int

    abstract fun creatPresenter(): P

    abstract fun recycle()

    fun hideActionBar() {
        //TODO kotlin接收java的东西，必须要用？允许为空
        supportActionBar?.hide();

    }


    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }


}