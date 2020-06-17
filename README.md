# Kotlin
kotlin知识总结


> Kotlin学习网站
- https://developer.android.com/kotlin?hl=zh-cn

- https://www.jetbrains.com/

> 定义变量
```java

    //可变变量,可读可写
    var name:String = "zhong"
    name = "zhongxiaohong"
    
    //不可修改变量，只可以读
    val name2:String = "luo"
    name2 ="luoxiaoling" //这一行会报错
    
```

> 类型推导

比如 
var info = "AAA",可以根据"AAA"类型推导为String
var info2 = 'A' 类型推到为Char
var info3 = 99 类型推导为Int

kotlin  是静态语言，编译期确定类型，比如：

var age = 28  //可以这样

age  = ""  //会报错，当时js可以



> 如何将kotlin转换成对应的Java代码

![](https://github.com/ZhongXiaoHong/Kotlin/blob/master/61711111111111111.jpg)

![](https://github.com/ZhongXiaoHong/Kotlin/blob/master/6172222222222222.png)

![](https://github.com/ZhongXiaoHong/Kotlin/blob/master/617333333333222222666.png)

![](https://github.com/ZhongXiaoHong/Kotlin/blob/master/617456789.png)

> 函数

定义：

//Unit 相当于java中的void,:Unit可以省略

fun   main:Unit(){

}

**有形参，有返回值函数**

fun  add(num1:Int,num2:Int):Int{
    return num1+num2;
}

可以简化成：

//返回类型是通过（num1+num2）的结果类型推导来确定的 

fun add(num1:Int,num2:Int)= num1+num2

**可变参数的函数**

fun method(vararg value:Int){

}

相当于java的

void method(List<Integer> value){

}

如何调用：

method(1,2,3,4,5,6)

**lambda表达式函数**

val  add : (Int,Int)->Int ={num1,num2->num1+num2}

> kotlin 函数与java 方法的不同

kotlin  函数可以写在类的外面也可以写在类的里面，

Java的方法只能写在类的里面

> 字符串模板

**$表示一个变量名或者变量值**

比如：

var name  = "zxh"

var age = 18

print("name=$name , age = $age")

**换行**

String  test = """

AAAAAA

BBBBBB

CCCCCC

""".trimIndent()//trimIndent 表示删除前置空格

**转义**

显示$999.99

String  test = """

${'$'}999.99

""".trimIndent()

> 空检查机制

比如：

    var test:String? = null
    
    以上相当于发出警告 test可能为null,所以使用的时候需要作空检查，如下：
    
    第一种：
    
    print(test?.length)//如果test为null,就不执行.legth
   
   第二种：
   
   print(test!!.length)//相当于不管空不空强制执行，为空会报错
   
   第三种：
   
   if(test!=null){
     print(test.length)
   }
   
  
> 函数如何默认返回null

比如以下函数使用：Int?,表示可以返回null

 fun method(name:String):Int?{
 
 if(name = "A"){
 return 1
 }
 
 return null
 }
 
 46--23
    
    












