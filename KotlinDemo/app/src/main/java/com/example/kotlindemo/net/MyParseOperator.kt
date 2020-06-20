package com.example.kotlindemo.net

import com.example.kotlindemo.bean.NetResult
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract  class MyParseOperator<T> : Observer<NetResult<T>>{

    abstract  fun onSuccess(data:T)

    abstract  fun onFailed(msg:String)

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(t: NetResult<T>) {

        onSuccess(t.data)
    }

    override fun onError(e: Throwable) {
      onFailed(e?.message?:"")
    }
}