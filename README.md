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


> 空检查机制

比如：

    var test:String? = null
    
    以上相当于发出警告 test可能为null,所以使用的时候需要作空检查，如下：
    
    第一种：
    
    print(test?.length)//如果test为null,就不执行.legth
    
   **拓展**
   
   不想输出null做法：
   
   println(test?.length?:"dsds")
    
    
   
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
 
 > 区间
 
 for(i int  1..9){
 
 }
 
 **设置步长**
 
  for(i int  1..9 step 2){
 
 }
 
 **排除最后一个**
 
   for(i int  1 until 9){//不会打印9
 
 }
    
 **降序要使用dowmTo** 
 
 for(i int  9 downTo 1){
 
 }
 
 
 **使用区间作数值大小判断**
 
 var value= 88;
 
 //判断value 是不是在1到100区间内
 
 if（value in 1..100）{
 
 }
 
 > 比较两个值
 
 val  name1 = "A"
 
  val  name2 = "B"
 
 **比较值本身**
 
 name1.equals(name2)//编译器不推荐使用
 
 name1==name2
 
 
 **比较对象地址**
 
 name1===name2
 
 
 > 数组定义
 
 **第一种**
 
 val nums[] = arrayOf(1,2,3,4,5,6)
 
 
 **第二种**
 
 val nums[] = Array(20,{value:Int->(value+10000)})
 
 
 
 > 条件表达式
 
 val num1 = 99999;
 
 val num2 =1111;
 
 **第1种**
 
 val  max = if(num1 > num2)  num1 else num2
 
 **第2种**
 
 val max = if(num1 > num2){
 
 //TODO 做很多其他逻辑
 
 num1
 }else{
 
  //TODO 做很多其他逻辑
  
  num2
 }
 
 
 > switch 功能
 
 val value = 1;
 
 when(value){
 
 in 1..3->print("1--3")
 
  in 4..6->print("1--3")
  
  else  ->print("1--3")
 
 }
 
 或者
 when(value){
 
 in 1..3->{
 //TOdo  做其他逻辑
 print("1--3")
 
 }
 
  in 4..6->{
  
  print("1--3")
  
  }
  
  else  ->{
  
  print("1--3")
  
  }
 
 }
 
when(value){

1,2,3,4,5,6-> print("1--6")

else-> print("else")

}

> 循环写法

for(i in  1..9){

}

var  items  = listOf(1,2,3,4,5,6)
    
    items.forEach { 
        print(it)
    }
    
  
  **打印下标**
     使用快捷： items.indices.for生成：
     
     
    for (index in items.indices) {
        
    }
      
      
    


> 循环标签

//在这里自定义标签zhong

zhong@for(i in  1..9){

    for(j in 1..9){
    
        if(j==5){
        
            break@zhong//直接跳出最外面循环
        }
    }
}


> 定义类

class Person(id:Int){//主构造

    //次构造   要包含主构造
    constructor(id:Int,name:String):this(id){
        
    }

    //次构造   要包含主构造
    constructor():this(101){

    }


}

> 类的继承实现

class Student (id:Int):Person(id){//Person类能被继承要添加 open字段，类默认实public final的

    //kotlin 变量全部是没有默认值的
    //比如 var value:String 是会报错的
    //如果初始值不想设置值要增加懒加载字段
    lateinit var value:String

    //lateinit修饰符只能修饰不可空类型，并且不允许修饰基础类型
    //下面这么写报错
    lateinit var t:Int

}




 
 
 
 
 
 
 
 
 
 
 
    












