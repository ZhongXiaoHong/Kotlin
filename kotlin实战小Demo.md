
# kotlin实战小Demo

> MVP的好处

1.分层清晰

2.各层可以拆卸，方便进行单元测试



> kotlin代码隔离不让java调用

```

```

> 扩展函数

```
fun main() {
    var stu = Student()
    stu.add(100,200)
}

fun Student.add(num:Int,num2:Int){
    print("结果 =${num+num2} ")
}

输出结果：结果 =300 

//Student类是空的并没有add方法
class Student {
}

Kotlin本身支持扩展函数，比如在FileReadWrite.kt中kotlin为File这个java类增加了扩展方法比如fun File.readText，可以为kotlin类、java类、第三方框架增加扩展函数
```

> java中调用kotlind的扩展函数



> 简单的高阶函数

```
fun main() {

    testGaoJie(false){//注意这个是函数调用的时候在加花括号，
        println(it)
        if(it=="flag ==  true"){
            //TODO 返回方法结果
            "OK"
        }else{
            "NO"
        }
    }
}

//TODO method:(String)->Unit
//表示method是方法名
//String 是形参类型
//Unit 返回类型
fun testGaoJie(flag:Boolean,method:(String)->String){

    if (flag){
        //TODO 调用方法之后返回计算结果
        var result = method("flag ==  true")
        println(result)
    }else{
        var result = method("flag ==  false")
        println(result)
    }
}
这里就是将函数当作参数
```

