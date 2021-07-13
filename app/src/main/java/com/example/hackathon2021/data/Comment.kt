package com.example.hackathon2021.data

data class Comment(
    val comment:String,
    val date:Long,
    val id:Int,
    val isMe:Boolean,
    val isWriter:Boolean,
    val user:User
)
