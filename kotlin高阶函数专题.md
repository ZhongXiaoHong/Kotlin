> 高阶函数的定义与调用

```kotlin
	
//TODO 1 这里是高阶函数的定义
  fun loginAction(name:String,pwd:String,method:(String,String)->Unit ){
      method(name,pwd)
  }



fun main() {
   
	
    //TODO 2-A 这里是高阶函数的调用
    loginAction("luoxiaoling","888168"){
        name,pwd->
        if(name=="luoxiaoling"&&pwd=="888168") println("登录成功！！")
        else  println("登录失败！！")
    }
    
    //TODO 2-B  这里是另外一个地方调用高阶函数
    loginAction("luoxiaoling","888168"){name,pwd->
            println("我是另外一个调用高阶函数的地方")
    }

}


```

【TODO 2】

method:(String,String)->Unit  是对高阶函数的定义，实际上理解简单点，可以把(String,String)->Unit 看作一个类型，method:(String,String)->Unit 表示method属于(String,String)->Unit 这个类型，只不过(String,String)->Unit 这个类型特殊一点，它是接收两个参数，第一个参数是String类型，第二个参数是String类型，返回值为Unit的函数.

**如何调用**

1. 常规调用方法的方式调用

   ```kotlin
     loginAction("luoxiaoling","888168",{ name, pwd->
           kotlin.io.println("我是第1个调用高阶函数的地方$name$pwd")
       })
   ```

   这种传参方式很熟悉，就是载方法的（）依次传入对应类型的参数，这里看下第三个传参，用花括号括起来了，把他看成一个函数，name,pwd表示这个函数需要两个形参，->之后的表示函数体要执行的语句。

   这样写运行是没问题的，

   ![QQ截图20200629213010](QQ截图20200629213010.png)



1. 