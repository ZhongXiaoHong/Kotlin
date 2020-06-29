package com.example.kotlindemo.gaojie


fun main() {

    loginAction("luoxiaoling","888168",{ name, pwd->
        kotlin.io.println("我是第1个调用高阶函数的地方$name$pwd")
    })

}

  fun loginAction(name:String,pwd:String,method:(String,String)->Unit ){
      method(name,pwd)
  }





















//    //TODO 使用高阶实现登录
//    loginAction("luoxiaoling","888168"){name,pwd->
//
//        if(name=="luoxiaoling"&&pwd=="888168") println("登录成功！！")
//        else  println("登录失败！！")
//
//    }
//
//    loginAction("luoxiaoling","888168"){name,pwd->
//            println("我是另外一个调用高阶函数的地方$name$pwd")
//    }
//
//   var test = {name:String,pwd:String->
//        kotlin.io.println("我是第三个调用高阶函数的地方$name$pwd")
//    }
//    loginAction("luoxiaoling","888168",test)
//

