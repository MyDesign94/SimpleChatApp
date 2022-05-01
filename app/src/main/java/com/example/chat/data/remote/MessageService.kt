package com.example.chat.data.remote

import com.example.chat.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object {
        const val BASE_URL = "https://sometime-chat-server.herokuapp.com"
//        const val BASE_URL = "https://my-test-app-heroku21.herokuapp.com"
    }

    sealed class Endpoints(val url: String) {
        object GetAllMessages: Endpoints("$BASE_URL/messages")
    }
}