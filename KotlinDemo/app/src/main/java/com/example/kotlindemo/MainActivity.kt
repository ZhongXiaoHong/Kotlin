package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlindemo.api.Api
import com.example.kotlindemo.bean.LoginResponse
import com.example.kotlindemo.mvp.presenter.ILoginPresenter
import com.example.kotlindemo.mvp.presenter.LoginPresenter
import com.example.kotlindemo.mvp.view.ILoginView
import com.example.kotlindemo.net.MyParseOperator
import com.example.kotlindemo.net.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ILoginView {

    lateinit var presenter: ILoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NetManager.Builder().setBaseUrl("https://www.wanandroid.com").build()
         presenter = LoginPresenter(this)
    }

    fun login(view: View) {

        var name = nameEd.text.toString();
        var pw = pwEd.text.toString();

        presenter.loginAction(name, pw)



    }


    override fun loginSuccess(data: LoginResponse) {

        //TODO koilin中访问"Mainactivity.this"使用“this@MainActivity”
        Toast.makeText(this@MainActivity, "登录成功", Toast.LENGTH_LONG).show()
        println("onsuccess = $data")
    }

    override fun loginFailed(data: String) {


        Toast.makeText(this@MainActivity, "登录失败", Toast.LENGTH_LONG).show()
        println("onsuccess = $data")
    }

}
