package com.example.kotlindemo.mvp.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.mvp.presenter.BasePresent

abstract class BaseActivity<P : BasePresent> :AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }



}