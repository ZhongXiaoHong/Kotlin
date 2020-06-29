> 高阶函数的定义与调用

```kotlin
	
//TODO 1 这里是高阶函数的定义
  fun loginAction(name:String,pwd:String,method:(String,String)->Unit ){
      method(name,pwd)
  }

```

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

但是这样的写法还是有问题的，有点不好看，如果传入的函数方法体执行的逻辑很多，这样写就更加难看了，实际上编辑器也是会提醒的

![6292159](6292159.png)

把鼠标放到波浪线，会给出优化提示：

![6292202](6292202.png)

优化后代码如下：

![6292205](6292205.png)



2.编辑器推荐写法

```kotlin
    loginAction("luoxiaoling","888168") { name, pwd->
        kotlin.io.println("我是第1个调用高阶函数的地方$name$pwd")
    }
```

这个写法在【1】有提过了，其实就是将要传的函数体这个参数放到括号外面来，这样更加美观可读性也更好。



3.第三种写法

实际上第2种写法刚开始看着是有些不习惯的，既然【1】提到直接将函数体放在括号内传参可读性不佳，那我们干脆用一个变量来代替函数体，如下：

```kotlin
   
	var method = {name:String,pwd:String->
        kotlin.io.println("我是第三个调用高阶函数的地方$name$pwd")
    }

    loginAction("luoxiaoling","888168",method)
```

以上看起来对初学者来说又比较容易接受一点，不过相信用久了kotlin，还是会觉得第【2】种是最佳的。



> 为高阶函数取别名

```kotlin
//TODO 使用typealias类型别名关键字取别名
typealias  Method = (String, String) -> Unit


//  fun loginAction(name:String,pwd:String,method:(String,String)->Unit ){
//      method(name,pwd)
//  }

//TODO 高阶函数定义
fun loginAction(name: String, pwd: String, method: Method) {
    method(name, pwd)
}
```



