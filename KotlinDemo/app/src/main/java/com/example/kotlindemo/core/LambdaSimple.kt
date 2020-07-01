package com.example.kotlindemo.core


fun main() {

    //:(完整类型)
    //={具体详情}
    var m1: (Int, Int) -> Int = { num1, num2 -> num1 * num2 }
    println("m1 = ${m1(2, 4)}")

    var n1 = { num1: Int, num2: Int -> num1 * num2 }
    println("n1 = ${n1(2, 4)}")

    var m2: (Int, Int) -> Double = { num1, num2 -> num1 + num2.toDouble() }
    println("m2 = ${m2(2, 4)}")

    var n2 = { num1: Int, num2: Int -> num1 + num2.toDouble() }
    println("n2 = ${n2(2, 4)}")

    var m3: (String, String) -> Unit = { str1, str2 -> println("m3 = $str1 VS $str2") }
    m3("马刺", "热火")

    var n3 = { str1: String, str2: String -> println("n3 = $str1 VS $str2") }
    n3("马刺", "热火")

    var m4: (String) -> String = { str -> str }
    println("m4 = ${m4("笑傲江湖")}")

    var n4 = { str: String ->
        str
    }
    println("n4 = ${n4("笑傲江湖")}")

    var m5: (code: Int) -> Unit = {
        print("m5 : ")
        when (it) {
            1 -> println("这是一")
            in 2..10 -> println("这是二到十")
            else -> println("其他")
        }

    }
    m5(10)

    var n5 = { it: Int ->
        print("n5 : ")
        when (it) {
            1 -> println("这是一")
            in 2..10 -> println("这是二到十")
            else -> println("其他")
        }
    }
    n5(10)

    var m6: (Int, Int, Int) -> Unit =
        { num1, num2, num3 -> println("m6 : num1 = $num1 ,num2 = $num2 ,num3 = $num3") }
    m6(1, 2, 3)

    var n6 = { num1: Int, num2: Int, num3: Int ->
        println("n6 : num1 = $num1 ,num2 = $num2 ,num3 = $num3")
    }
    n6(1, 2, 3)

    var m7: () -> Unit = { println("m7 = 这是无参无返回函数") }
    m7()

    var n7 = { println("m7 = 这是无参无返回函数") }
    n7()

    var m8:(Char)->String={sex->if('M'==sex)"男性" else "女性"}
    println("m8 = ${m8('M')}")

    var n8 = {sex:Char->if('M'==sex)"男性" else "女性"}
    println("n8 = ${n8('M')}")

    //TODO  更加骚的操作，覆盖函数体
    var m9:(Int)->Unit= { num->println("m9 覆盖前输入了$num")}
    m9(9)
    m9 = {
        println("m9 覆盖后输入了$it")
    }
    m9(9)
    var n9={
        num:Int->println("n9 覆盖前输入了$num")
    }
    n9(9)
    n9 = {
        println("n9 覆盖后输入了$it")
    }
    n9(9)

    var m10:(Int)->Int={
        println("m10 先打印后返回值的10倍")
        it*10
    }
    println("m10 ${m10(10)}")

    var n10 = {
        num:Int-> println("m10 先打印后返回值的10倍")
        num*10
    }
    println("n10 ${n10(10)}")
}