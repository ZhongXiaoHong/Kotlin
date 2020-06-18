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

> 使用data编写Java Bean类


```java
package com.silang.cassloadertest

data class User(val id:Int,val name:String)

```
相当于JAvA


```java

public final class User {
   private final int id;
   @NotNull
   private final String name;

   public final int getId() {
      return this.id;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public User(int id, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.id = id;
      this.name = name;
   }

   public final int component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.name;
   }

   @NotNull
   public final User copy(int id, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      return new User(id, name);
   }

   // $FF: synthetic method
   @NotNull
   public static User copy$default(User var0, int var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.name;
      }

      return var0.copy(var1, var2);
   }

   @NotNull
   public String toString() {
      return "User(id=" + this.id + ", name=" + this.name + ")";
   }

   public int hashCode() {
      int var10000 = this.id * 31;
      String var10001 = this.name;
      return var10000 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof User) {
            User var2 = (User)var1;
            if (this.id == var2.id && Intrinsics.areEqual(this.name, var2.name)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}


```

```java

    
    var  user  = User(10086,"zxh")
    //相当于定义两个变量，然后把user对应的属性赋值过去
    val(myId,myName) = user.copy() 
    print("id =$myId,name = $myName")
    
     //拒收id,只接受name
    val(_,myName2) = user.copy()
    print("name = $myName2")
    
```

> 使用object实现单例

```java
//只实例化一次相当于单例
object HttpManager{
    
    fun doSth(){
        print("做点事儿")
    }
    
}
```
![](https://github.com/ZhongXiaoHong/Kotlin/blob/master/6182349.jpg)

相当于Java

```java
import kotlin.Metadata;

@Metadata(
   mv = {1, 1, 13},
   bv = {1, 0, 3},
   k = 1,
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"},
   d2 = {"Lcom/silang/cassloadertest/HttpManager;", "", "()V", "doSth", "", "app"}
)
public final class HttpManager {
   public static final HttpManager INSTANCE;

   public final void doSth() {
      String var1 = "做点事儿";
      boolean var2 = false;
      System.out.print(var1);
   }

   private HttpManager() {
   }

   static {
      HttpManager var0 = new HttpManager();
      INSTANCE = var0;
   }
}

```



 
 
 
 
 
 
 
 
 
 
 
    












