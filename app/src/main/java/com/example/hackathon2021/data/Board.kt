package com.example.hackathon2021.data

import java.util.*

data class Board(
    val commentsNum: Int,
    val content: String,
    val date: Date,
    val id: Int,
    val isMe: Boolean,
    val isUpdated: Boolean,
    val title:String,
    val user:User
)
