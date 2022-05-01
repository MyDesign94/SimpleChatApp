package com.example.chat.data.remote.dto

import com.example.chat.domain.model.Message
import com.example.chat.domain.model.User
import kotlinx.serialization.Serializable
import java.text.DateFormat
import java.util.*

@Serializable
data class UserDto(
    val id: String,
    val name: String
) {
    fun  toUser(): User {
        return User(
            id = id,
            username = name
        )
    }
}
