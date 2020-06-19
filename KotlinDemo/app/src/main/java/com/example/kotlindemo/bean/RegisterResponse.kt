package com.example.kotlindemo.bean

data class RegisterResponse(
    val admin: Boolean,
    val chapterTops: List<*>,
    val collectIds: List<*>,
    val email: String?,
    val icon: String?,
    val id: Int, 
    var nickname: String,
    var password: String,
    var publicName: String,
    var token: String,
    var type: Int,
    var username: String
)