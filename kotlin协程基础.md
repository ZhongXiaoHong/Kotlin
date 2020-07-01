# Kotlin协程基础
> 协程是什么



> 协程的优点

异步代码往往有很多回调，特别是嵌套调用的时候，甚至会遇到回调地狱，回调的同时可能还会涉及到线程切换，再加上业务逻辑、异常处理等等会让代码可读性降低，排错困难大，而协程则可以优雅的处理这些问题



> kotlin中对线程的封装

```kotlin
val myThread = thread {
    //TODO 这里相当于java Runnable的run方法
    //TODO 这种写法默认线程创建之后会自动执行
}
```

创建线程但不立即执行,如下：

```kotlin
//TODO 指定start  false
val myThread = thread(start = false) {

}

myThread.start()
```

