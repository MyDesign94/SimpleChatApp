package com.example.chat.domain.model

import java.text.DateFormat
import java.util.*

data class Message(
    val text: String,
    val formattedTime: String,
    val username: String
)
