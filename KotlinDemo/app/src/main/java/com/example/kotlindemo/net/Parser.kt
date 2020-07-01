package com.example.kotlindemo.net

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.kotlindemo.bean.NetResult
import java.util.function.Consumer

@RequiresApi(Build.VERSION_CODES.N)
interface   Parser<T> : Consumer<NetResult<T>>{


}